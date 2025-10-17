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

# 2️⃣ Definir Fluxo

Agora defina o **fluxo básico de uso do app**.\
O app deve simular uma aplicação com autenticação e consumo de dados da API.

**Fluxo sugerido:**

**1) LoginPage** → o usuário faz login com credenciais fixas:

```json
POST https://dummyjson.com/auth/login
{
  "username": "kminchelle",
  "password": "0lelplR"
}
```

**2) Salvar token localmente** (armazenamento seguro).

**3) HomePage** → consome o recurso escolhido (ex.: products).

**4) DetailsPage** → mostra os detalhes do item clicado.

**5) Logout** → limpa o token e volta à tela de login.
