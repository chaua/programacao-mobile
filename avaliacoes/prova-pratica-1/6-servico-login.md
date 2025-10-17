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

# 6️⃣ Serviço Login

#### 🎯 Objetivo

Implementar o serviço que faz `POST /auth/login`, valida a resposta, trata erros comuns e **retorna o token** (o armazenamento virá no passo 7).

### 📁 Estrutura (tudo de login em `modules/auth`)

Crie estes arquivos/pastas:

```
lib/
├── core/
│   ├── constants/
│   │   └── env.dart                 # do passo 5
│   └── exceptions/
│       └── app_exceptions.dart      # exceções reutilizáveis
└── modules/
    └── auth/
        ├── models/
        │   └── auth_models.dart
        └── services/
            └── auth_service.dart
```

### 🧱 `core/exceptions/app_exceptions.dart`

```dart
// lib/core/exceptions/app_exceptions.dart

class ApiException implements Exception {
  final String message;
  final int? statusCode;

  ApiException(this.message, {this.statusCode});

  @override
  String toString() => 'ApiException($statusCode): $message';
}

class NetworkException extends ApiException {
  NetworkException(String message) : super(message);
}

class UnauthorizedException extends ApiException {
  UnauthorizedException(String message) : super(message, statusCode: 401);
}
```

### 🧩 `modules/auth/models/auth_models.dart`

```dart
// lib/modules/auth/models/auth_models.dart

class LoginRequest {
  final String username;
  final String password;

  const LoginRequest({required this.username, required this.password});

  Map<String, dynamic> toJson() => {
        'username': username,
        'password': password,
        // 'expiresInMins': 60, // opcional no DummyJSON
      };
}

class AuthResponse {
  final String token;
  final int? id;
  final String? name;
  final String? email;

  const AuthResponse({
    required this.token,
    this.id,
    this.name,
    this.email,
  });

  factory AuthResponse.fromJson(Map<String, dynamic> json) {
    return AuthResponse(
      token: json['token'] as String,
      id: json['id'] as int?,
      name: (json['firstName'] != null && json['lastName'] != null)
          ? '${json['firstName']} ${json['lastName']}'
          : null,
      email: json['email'] as String?,
    );
  }
}
```

### 🔌 `modules/auth/services/auth_service.dart`

```dart
// lib/modules/auth/services/auth_service.dart

import 'dart:convert';
import 'package:http/http.dart' as http;

import '../../../core/constants/env.dart';
import '../../../core/exceptions/app_exceptions.dart';
import '../models/auth_models.dart';

class AuthService {
  final http.Client _http;

  AuthService({http.Client? httpClient}) : _http = httpClient ?? http.Client();

  Uri _loginUri() => Uri.parse('${Env.baseUrl}${Env.loginEndpoint}');

  /// POST /auth/login → retorna AuthResponse (com token).
  /// O armazenamento do token será feito no Passo 7 (AuthRepository).
  Future<AuthResponse> login(LoginRequest data) async {
    try {
      final resp = await _http
          .post(
            _loginUri(),
            headers: {'Content-Type': 'application/json'},
            body: jsonEncode(data.toJson()),
          )
          .timeout(Duration(seconds: Env.requestTimeout));

      if (resp.statusCode == 200) {
        final map = jsonDecode(resp.body) as Map<String, dynamic>;
        final token = map['token'];
        if (token == null || (token is String && token.isEmpty)) {
          throw ApiException('Resposta sem token', statusCode: resp.statusCode);
        }
        return AuthResponse.fromJson(map);
      }

      if (resp.statusCode == 401) {
        final msg = _extractMessage(resp.body) ?? 'Credenciais inválidas';
        throw UnauthorizedException(msg);
      }

      final msg = _extractMessage(resp.body) ?? 'Erro ${resp.statusCode}';
      throw ApiException(msg, statusCode: resp.statusCode);
    } on UnauthorizedException {
      rethrow;
    } on ApiException {
      rethrow;
    } on Exception catch (e) {
      throw NetworkException('Falha de rede: ${e.toString()}');
    }
  }

  String? _extractMessage(String body) {
    try {
      final map = jsonDecode(body);
      if (map is Map && map['message'] is String) return map['message'] as String;
    } catch (_) {}
    return null;
  }
}
```

### 🧪 Teste rápido

Use temporariamente (ex.: em um botão na `home_page.dart`) só para validar a chamada:

```dart
import 'modules/auth/services/auth_service.dart';
import 'modules/auth/models/auth_models.dart';

final service = AuthService();
final req = const LoginRequest(username: 'kminchelle', password: '0lelplR');

service.login(req).then((auth) {
  print('Token: ${auth.token.substring(0, 12)}...');
}).catchError((e) {
  print('Erro login: $e');
});
```
