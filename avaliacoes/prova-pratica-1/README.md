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
    visible: false
  metadata:
    visible: false
---

# 📑 Prova prática 2ºB - 1

## :dart: Objetivo

Desenvolver um aplicativo Flutter que consome uma **API pública com autenticação** (DummyJSON) e exibe uma **lista de recursos** (exemplo: produtos), com navegação para uma tela de **detalhes**.

O foco é aplicar **requisições HTTP**, **autenticação por token**, **armazenamento local**, **tratamento de erros** e **atualização de estado com `setState()`**.

## :clipboard: Requisitos obrigatórios

O aplicativo deve conter **as três telas abaixo**, funcionando conforme o fluxo:

1. **Splash Screen**
   * Verifica se há um token salvo localmente.
   * Redireciona automaticamente para Login (se não autenticado) ou Home (se já autenticado).
2. **Login Page**
   * Realiza autenticação via `POST https://dummyjson.com/auth/login`.
   * Usa as credenciais de teste:\
     `username: emilys`\
     `password: emilypass`
   * Armazena o token com `flutter_secure_storage` ou `shared_preferences`.
   * Ao logar, navega para a tela principal.
3. **Home Page (Lista de Produtos)**
   * Lista itens vindos da API (`GET https://dummyjson.com/products`).
   * Exibe título, imagem e preço dos produtos.
   * Deve permitir **scroll infinito** e **pull-to-refresh**.
   * Ao tocar em um item, abre a **tela de detalhes**.
4. **Tela de Detalhes (Produto)**
   * Mostra informações completas do item (imagem grande, título, descrição, preço, marca, categoria e avaliação).
   * Deve permitir voltar à lista.

## :speaking\_head: Apresentação

* Cada grupo apresentará o app funcionando no **emulador ou dispositivo real**.
* Durante a apresentação, devem:
  1. Demonstrar o **fluxo completo**: Splash → Login → Lista → Detalhes.
  2. Explicar **como ocorre o consumo da API** e onde o token é salvo.
  3. Mostrar como o `setState()` foi usado para gerenciar estados (`loading`, `erro`, `dados`).
