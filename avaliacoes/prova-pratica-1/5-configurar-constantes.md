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

# 5️⃣ Configurar Constantes

perfeito 👏 vamos detalhar o **passo 5** — com título curto, organização em pastas e código comentado.

***

### **5️⃣ Configurar Constantes**

#### 🎯 Objetivo

Centralizar todas as informações fixas da aplicação (URLs, endpoints, timeouts, nomes de storage, etc.) em um único arquivo.

#### 📁 Estrutura de pastas sugerida

Dentro de `lib/`, crie o seguinte caminho:

```
lib/
├── core/
│   └── constants/
│       └── env.dart
```

Essa estrutura é importante para deixar o projeto limpo e fácil de escalar.

#### 🧩 Arquivo: `env.dart`

```dart
// lib/core/constants/env.dart

class Env {
  /// URL base da API pública
  static const String baseUrl = 'https://dummyjson.com';

  /// Endpoints principais
  static const String loginEndpoint = '/auth/login';

  // Exemplo de outros recursos (os alunos escolherão um)
  static const String productsEndpoint = '/products';
  static const String usersEndpoint = '/users';
  static const String postsEndpoint = '/posts';
  static const String todosEndpoint = '/todos';
  static const String recipesEndpoint = '/recipes';

  /// Timeout padrão para requisições (em segundos)
  static const int requestTimeout = 10;

  /// Nome das chaves de armazenamento local
  static const String tokenKey = 'auth_token';

  /// Texto de erro padrão (para exibir na UI)
  static const String genericError = 'Algo deu errado. Tente novamente.';
}
```

#### 💡 Boas práticas

1. **Evitar strings espalhadas pelo código** – tudo fica centralizado em `Env`.
2. **Facilitar manutenção** – se a URL mudar, basta alterar em um lugar.
3. **Dar nomes intuitivos** – use nomes que façam sentido (`tokenKey`, `requestTimeout`, etc.).
4. **Evitar lógica em constantes** – mantenha apenas valores fixos e simples.

{% hint style="info" %}
Em projetos maiores, é comum ler variáveis de ambiente com o pacote [`flutter_dotenv`](https://pub.dev/packages/flutter_dotenv).
{% endhint %}
