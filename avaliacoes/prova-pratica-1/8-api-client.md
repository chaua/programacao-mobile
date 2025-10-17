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

# 8️⃣ API Client

#### 🎯 Objetivo

Criar um **cliente HTTP central** que:

1. monte URLs usando o `Env.baseUrl`,
2. **injete automaticamente** `Authorization: Bearer <token>` do `AuthRepository`,
3. padronize timeouts, headers e tratamento de erros (401, 404, 429 etc.).

### 📁 Estrutura&#x20;

```
lib/
├── core/
│   ├── constants/env.dart
│   └── exceptions/app_exceptions.dart
├── modules/
│   └── auth/
│       └── repositories/auth_repository.dart
└── shared/
    └── services/
        └── api_client.dart        # (novo)
```

### 🔌 `shared/services/api_client.dart`

```dart
// lib/shared/services/api_client.dart
import 'dart:convert';
import 'package:http/http.dart' as http;

import '../../core/constants/env.dart';
import '../../core/exceptions/app_exceptions.dart';
import '../../modules/auth/repositories/auth_repository.dart';

/// Cliente HTTP central da aplicação.
/// - Injeta Authorization automaticamente (se houver token).
/// - Aplica timeout padrão.
/// - Converte erros para AppExceptions.
/// - Expõe helpers GET/POST genéricos com JSON.
///
/// Uso típico dentro de Repositories de recurso:
///   final data = await api.getJson('/products', query: {'limit': '10'});
class ApiClient extends http.BaseClient {
  final http.Client _inner;
  final AuthRepository _authRepo;

  ApiClient({
    http.Client? inner,
    AuthRepository? authRepository,
  })  : _inner = inner ?? http.Client(),
        _authRepo = authRepository ?? AuthRepository();

  // ==== Helpers públicos ====

  Future<Map<String, dynamic>> getJson(
    String path, {
    Map<String, String>? query,
    Map<String, String>? headers,
  }) async {
    final resp = await get(
      _buildUri(path, query),
      headers: _defaultHeaders()..addAll(headers ?? {}),
    ).timeout(Duration(seconds: Env.requestTimeout));

    return _decodeJsonOrThrow(resp);
  }

  Future<Map<String, dynamic>> postJson(
    String path, {
    Map<String, String>? query,
    Object? body,
    Map<String, String>? headers,
  }) async {
    final resp = await post(
      _buildUri(path, query),
      headers: _defaultHeaders()..addAll(headers ?? {}),
      body: body is String ? body : jsonEncode(body),
    ).timeout(Duration(seconds: Env.requestTimeout));

    return _decodeJsonOrThrow(resp);
  }

  // ==== BaseClient override (injeta Authorization) ====

  @override
  Future<http.StreamedResponse> send(http.BaseRequest request) async {
    // Headers comuns
    request.headers.addAll(_defaultHeaders());

    // Authorization (se houver token)
    final token = await _authRepo.getToken();
    if (token != null && token.isNotEmpty) {
      request.headers['Authorization'] = 'Bearer $token';
    }

    // Executa e lida com erros de rede/timeout
    try {
      final streamed = await _inner.send(request);
      return streamed;
    } on Exception catch (e) {
      // Timeout/sem rede/etc. serão capturados onde os métodos aguardam o Future,
      // mas aqui deixamos uma mensagem consistente:
      throw NetworkException('Falha de rede: ${e.toString()}');
    }
  }

  // ==== Utils privados ====

  Uri _buildUri(String path, Map<String, String>? query) {
    final cleanPath = path.startsWith('/') ? path : '/$path';
    return Uri.parse('${Env.baseUrl}$cleanPath').replace(queryParameters: query);
  }

  Map<String, String> _defaultHeaders() => {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      };

  Map<String, dynamic> _decodeJsonOrThrow(http.Response resp) {
    // 2xx
    if (resp.statusCode >= 200 && resp.statusCode < 300) {
      if (resp.body.isEmpty) return <String, dynamic>{};
      final decoded = jsonDecode(resp.body);
      if (decoded is Map<String, dynamic>) return decoded;
      // Algumas respostas do DummyJSON podem trazer listas; normalize se precisar:
      return {'data': decoded};
    }

    // Erros comuns didáticos
    if (resp.statusCode == 401) {
      // Opcional: limpar token aqui se quiser forçar logout imediato.
      // await _authRepo.clearToken();
      final msg = _extractMessage(resp.body) ?? 'Não autorizado (401)';
      throw UnauthorizedException(msg);
    }
    if (resp.statusCode == 404) {
      throw ApiException('Recurso não encontrado (404)', statusCode: 404);
    }
    if (resp.statusCode == 429) {
      throw ApiException('Muitas requisições (429). Tente novamente em instantes.', statusCode: 429);
    }

    final msg = _extractMessage(resp.body) ?? 'Erro ${resp.statusCode}';
    throw ApiException(msg, statusCode: resp.statusCode);
  }

  String? _extractMessage(String body) {
    try {
      final map = jsonDecode(body);
      if (map is Map && map['message'] is String) return map['message'] as String;
      if (map is Map && map['error'] is String) return map['error'] as String;
    } catch (_) {}
    return null;
  }
}
```

### 🧠 Dicas&#x20;

* **Um lugar só** para Authorization/timeout/headers → menos bug e mais aprendizado claro.
* **`BaseClient`** facilita injetar o token sem repetir código em cada request.
* **Tratamento de erros** coerente: a UI só precisa capturar `UnauthorizedException`, `NetworkException` e `ApiException`.

