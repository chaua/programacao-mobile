---
layout:
  width: default
  title:
    visible: true
  description:
    visible: false
  tableOfContents:
    visible: true
  outline:
    visible: false
  pagination:
    visible: true
  metadata:
    visible: false
---

# 9️⃣ Splash e Login

### 🎯 Objetivo

* **Splash:** checar sessão (`isLoggedIn`) e redirecionar para **Login** ou **Home**.
* **Login:** coletar `username/password`, chamar `AuthService.login`, salvar token via `AuthRepository` e navegar para **Home**.
* **Sem gerenciadores externos:** somente `setState()` para loading/erro.

### 🗂️ Estrutura

```
lib/
├── app/
│   └── app_routes.dart                  # rotas com dependências
├── modules/
│   ├── login/
│   │   ├── login_page.dart
│   │   ├── login_model.dart
│   │   └── login_controller.dart
│   └── splash/
│       └── splash_page.dart
└── modules/home/home_page.dart          # tela inicial
```

### 🧭 Rotas&#x20;

> Atualize seu `lib/app/app_routes.dart` para incluir **splash** e **login** e injetar `AuthService`/`AuthRepository`.

```dart
// lib/app/app_routes.dart
import 'package:flutter/widgets.dart';

import '../modules/home/home_page.dart';
import '../modules/splash/splash_page.dart';
import '../modules/login/login_page.dart';

// dependências
import '../modules/auth/services/auth_service.dart';
import '../modules/auth/repositories/auth_repository.dart';

class AppRoutes {
  // Nomes das rotas
  static const String home = '/';
  static const String splash = '/splash';
  static const String login = '/login';

  /// Gera as rotas com dependências resolvidas
  static Future<Map<String, WidgetBuilder>> getRoutes() async {
    final authService = AuthService();
    final authRepository = AuthRepository();

    return {
      splash: (_) => SplashPage(authRepository: authRepository),
      login:  (_) => LoginPage(
        authService: authService,
        authRepository: authRepository,
      ),
      home:   (_) => const HomePage(),
    };
  }
}
```

#### Como usar as rotas

**1) Preparar no `main.dart` :**

```dart
// lib/main.dart
import 'package:flutter/material.dart';
import 'app/app_routes.dart';
import 'app/app_widget.dart'; // se quiser manter seu AppWidget

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  final routes = await AppRoutes.getRoutes();
  runApp(AppWidget(routes: routes)); // AppWidget precisa aceitar 'routes'
}
```

```dart
// lib/app/app_widget.dart (exemplo mínimo)
import 'package:flutter/material.dart';
import 'app_routes.dart';

class AppWidget extends StatelessWidget {
  final Map<String, WidgetBuilder> routes;
  const AppWidget({super.key, required this.routes});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: AppRoutes.splash,
      routes: routes,
    );
  }
}
```

### 🟣  `splash_page.dart`

```dart
// lib/modules/splash/splash_page.dart
import 'package:flutter/material.dart';
import '../../auth/repositories/auth_repository.dart';
import '../../app/app_routes.dart' as routes;

class SplashPage extends StatefulWidget {
  final AuthRepository authRepository;
  const SplashPage({super.key, required this.authRepository});

  @override
  State<SplashPage> createState() => _SplashPageState();
}

class _SplashPageState extends State<SplashPage> {
  @override
  void initState() {
    super.initState();
    // pequena fila para garantir contexto montado
    Future.microtask(_decideStartRoute);
  }

  Future<void> _decideStartRoute() async {
    final logged = await widget.authRepository.isLoggedIn();
    if (!mounted) return;
    Navigator.pushReplacementNamed(
      context,
      logged ? routes.AppRoutes.home : routes.AppRoutes.login,
    );
  }

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Center(
        child: CircularProgressIndicator(),
      ),
    );
  }
}
```

### 🔵  `login_model.dart`

```dart
// lib/modules/login/login_model.dart
class LoginModel {
  String username;
  String password;

  LoginModel({this.username = '', this.password = ''});

  bool get isValid => username.trim().isNotEmpty && password.isNotEmpty;
}
```

#### Controller — `login_controller.dart`

```dart
// lib/modules/login/login_controller.dart
import '../../auth/services/auth_service.dart';
import '../../auth/repositories/auth_repository.dart';
import '../../auth/models/auth_models.dart';
import '../../core/exceptions/app_exceptions.dart';
import 'login_model.dart';

class LoginController {
  final AuthService _service;
  final AuthRepository _repo;

  LoginController({required AuthService service, required AuthRepository repository})
      : _service = service,
        _repo = repository;

  /// Executa login e persiste o token. Lança exceções específicas para a UI tratar.
  Future<void> doLogin(LoginModel model) async {
    if (!model.isValid) {
      throw ApiException('Preencha usuário e senha');
    }
    final resp = await _service.login(
      LoginRequest(username: model.username, password: model.password),
    );
    await _repo.saveToken(resp.token);
  }
}
```

#### Página — `login_page.dart`&#x20;

```dart
// lib/modules/login/login_page.dart
import 'package:flutter/material.dart';
import '../auth/repositories/auth_repository.dart';
import '../auth/services/auth_service.dart';
import '../core/exceptions/app_exceptions.dart';
import '../app/app_routes.dart' as routes;

import 'login_model.dart';
import 'login_controller.dart';

class LoginPage extends StatefulWidget {
  final AuthService authService;
  final AuthRepository authRepository;

  const LoginPage({
    super.key,
    required this.authService,
    required this.authRepository,
  });

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final _userCtrl = TextEditingController(text: 'kminchelle'); // facilita teste
  final _passCtrl = TextEditingController(text: '0lelplR');
  final _formKey = GlobalKey<FormState>();

  late LoginController _controller;
  bool _loading = false;
  String? _error;

  @override
  void initState() {
    super.initState();
    _controller = LoginController(
      service: widget.authService,
      repository: widget.authRepository,
    );
  }

  @override
  void dispose() {
    _userCtrl.dispose();
    _passCtrl.dispose();
    super.dispose();
  }

  Future<void> _onSubmit() async {
    setState(() {
      _error = null;
    });

    if (!(_formKey.currentState?.validate() ?? false)) return;

    setState(() => _loading = true);

    final model = LoginModel(
      username: _userCtrl.text,
      password: _passCtrl.text,
    );

    try {
      await _controller.doLogin(model);
      if (!mounted) return;
      Navigator.pushNamedAndRemoveUntil(
        context,
        routes.AppRoutes.home,
        (route) => false,
      );
    } on UnauthorizedException catch (e) {
      setState(() => _error = e.message);
    } on NetworkException catch (e) {
      setState(() => _error = e.message);
    } on ApiException catch (e) {
      setState(() => _error = e.message);
    } catch (e) {
      setState(() => _error = 'Erro inesperado. Tente novamente.');
    } finally {
      if (mounted) setState(() => _loading = false);
    }
  }

  String? _required(String? v) =>
      (v == null || v.trim().isEmpty) ? 'Campo obrigatório' : null;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Login')),
      body: Center(
        child: ConstrainedBox(
          constraints: const BoxConstraints(maxWidth: 420),
          child: Padding(
            padding: const EdgeInsets.all(16),
            child: Form(
              key: _formKey,
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  if (_error != null)
                    Padding(
                      padding: const EdgeInsets.only(bottom: 8),
                      child: Text(_error!, style: const TextStyle(color: Colors.red)),
                    ),
                  TextFormField(
                    controller: _userCtrl,
                    decoration: const InputDecoration(
                      labelText: 'Usuário',
                      hintText: 'ex.: kminchelle',
                    ),
                    validator: _required,
                    enabled: !_loading,
                  ),
                  const SizedBox(height: 12),
                  TextFormField(
                    controller: _passCtrl,
                    decoration: const InputDecoration(
                      labelText: 'Senha',
                      hintText: 'ex.: 0lelplR',
                    ),
                    obscureText: true,
                    validator: _required,
                    enabled: !_loading,
                  ),
                  const SizedBox(height: 20),
                  SizedBox(
                    width: double.infinity,
                    child: ElevatedButton(
                      onPressed: _loading ? null : _onSubmit,
                      child: _loading
                          ? const SizedBox(
                              width: 20, height: 20,
                              child: CircularProgressIndicator(strokeWidth: 2),
                            )
                          : const Text('Entrar'),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
```

### 💡 Dicas

* **Simples e direto:** `setState()` apenas para `loading`/`error`. Sem Provider/Riverpod aqui.
* **Pré-preenchido para testes:** deixar `kminchelle / 0lelplR` agiliza a validação em sala.
* **Navegação limpa:** no sucesso, use `pushNamedAndRemoveUntil` para limpar a pilha e evitar voltar ao Login.
* **Erros:** capture `UnauthorizedException`, `NetworkException` e `ApiException` para mensagens claras.
* **Splash minimalista:** só decide rota — sem UI complexa aqui.
