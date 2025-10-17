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

# 7️⃣ Repositório Autenticação

#### 🎯 Objetivo

Encapsular o **armazenamento seguro do token** (salvar/ler/apagar) e expor métodos simples para a UI verificar sessão (ex.: `isLoggedIn`). Nada de HTTP aqui — só persistência.

### 📁 Estrutura&#x20;

Crie estes arquivos/pastas:

```
lib/
└── modules/
    └── auth/
        ├── repositories/
        │   └── auth_repository.dart
        └── storage/
            └── secure_token_storage.dart
```

> Vamos separar **Repository** (regras de negócio de autenticação) de **Storage** (detalhe de como/onde salvar).

### 🧳 `modules/auth/storage/secure_token_storage.dart`

Implementa o detalhe técnico usando `flutter_secure_storage`.

```dart
// lib/modules/auth/storage/secure_token_storage.dart
import 'package:flutter_secure_storage/flutter_secure_storage.dart';

import '../../../core/constants/env.dart';

abstract class TokenStorage {
  Future<void> saveToken(String token);
  Future<String?> readToken();
  Future<void> deleteToken();
}

class SecureTokenStorage implements TokenStorage {
  final FlutterSecureStorage _storage;

  SecureTokenStorage({FlutterSecureStorage? storage})
      : _storage = storage ?? const FlutterSecureStorage();

  @override
  Future<void> saveToken(String token) async {
    await _storage.write(key: Env.tokenKey, value: token);
  }

  @override
  Future<String?> readToken() async {
    return _storage.read(key: Env.tokenKey);
  }

  @override
  Future<void> deleteToken() async {
    await _storage.delete(key: Env.tokenKey);
  }
}
```

### 🗂️ `modules/auth/repositories/auth_repository.dart`

Regras de negócio mínimas de sessão.

```dart
// lib/modules/auth/repositories/auth_repository.dart
import '../storage/secure_token_storage.dart';

class AuthRepository {
  final TokenStorage _storage;

  AuthRepository({TokenStorage? storage})
      : _storage = storage ?? SecureTokenStorage();

  /// Salva o token após login bem-sucedido
  Future<void> saveToken(String token) => _storage.saveToken(token);

  /// Lê o token; retorna null se não existir
  Future<String?> getToken() => _storage.readToken();

  /// Remove o token (logout)
  Future<void> clearToken() => _storage.deleteToken();

  /// Conveniência para a Splash/Login decidir rota
  Future<bool> isLoggedIn() async => (await _storage.readToken())?.isNotEmpty == true;
}
```

### 🔌 Como usar (exemplos rápidos)

#### 1) Após o login (na sua `LoginPage` ou controller):

```dart
import 'package:your_app/modules/auth/repositories/auth_repository.dart';
import 'package:your_app/modules/auth/services/auth_service.dart';
import 'package:your_app/modules/auth/models/auth_models.dart';

final authService = AuthService();
final authRepo = AuthRepository();

final resp = await authService.login(
  const LoginRequest(username: 'kminchelle', password: '0lelplR'),
);

await authRepo.saveToken(resp.token);
// navegue para a Home
```

#### 2) Na Splash (decidir rota inicial):

```dart
final authRepo = AuthRepository();
final logged = await authRepo.isLoggedIn();
if (logged) {
  // vai para Home
} else {
  // vai para Login
}
```

#### 3) No Logout (menu/botão sair):

```dart
final authRepo = AuthRepository();
await authRepo.clearToken();
// navegue para Login
```

### 🧠 Dicas&#x20;

* **Responsabilidades claras:** `AuthService` só fala com a API; `AuthRepository` só cuida da sessão local.
* **Testabilidade:** com a interface `TokenStorage`, dá para testar o repo com um storage fake (em memória).
* **Segurança:** `flutter_secure_storage` guarda criptografado (iOS Keychain / Android Keystore).

### 🧪 Teste Simples

Crie um botão temporário que:

1. chama `login` → `saveToken`
2. lê `getToken` e faz `print`
3. chama `clearToken`
4. lê de novo e verifica `null`

Isso valida o fluxo completo antes de integrar à UI final.
