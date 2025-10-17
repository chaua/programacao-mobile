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

# 1️⃣ Escolher Recurso

O DummyJSON oferece diversos recursos públicos, todos seguindo o mesmo padrão de API REST.

{% hint style="info" %}
Cada aluno deve escolher **um recurso** para trabalhar durante o exercício.
{% endhint %}

**Exemplos de recursos disponíveis:**

* `/products` → lista de produtos
* `/users` → lista de usuários
* `/posts` → lista de posts
* `/todos` → lista de tarefas
* `/recipes` → lista de receitas

**Sugestão de endpoints principais:**

* **Listagem:** `GET https://dummyjson.com/{recurso}`
* **Detalhe:** `GET https://dummyjson.com/{recurso}/{id}`
* **Busca (quando disponível):** `GET https://dummyjson.com/{recurso}/search?q=texto`

{% hint style="success" %}
_Exemplo:_\
Se o aluno escolher **products** →

* Lista: `https://dummyjson.com/products`
* Detalhe: `https://dummyjson.com/products/1`&#x20;
{% endhint %}
