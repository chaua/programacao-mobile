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

# 4️⃣ Adicionar Dependências

Agora vamos preparar o ambiente para consumir a API e armazenar o token.

**Pacotes principais (pubspec.yaml):**

```yaml
dependencies:
  flutter:
    sdk: flutter
  http: ^1.2.0
  provider: ^6.1.0
  flutter_secure_storage: ^9.0.0
```

**Função de cada um:**

* `http`: para fazer requisições REST.
* `provider`: para gerenciar estado de forma simples.
* `flutter_secure_storage`: para salvar o token com segurança (criptografado).

**Comando para instalar:**

```bash
flutter pub get
```

No **AndroidStudio** basta clicar no banner que aparece solicitando para atualizar as dependências
