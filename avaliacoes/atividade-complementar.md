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

# 🌟 Atividade complementar

## 🎯 **Objetivo**

O aluno deverá produzir **um tutorial completo**, extremamente detalhado, mostrando **como criar um aplicativo Flutter do zero e integrá-lo ao Firebase**, incluindo **autenticação com e-mail e senha** e **leitura/escrita no Firestore**.&#x20;

Sugestão de app: lista de tarefas com as opções de adicionar nova tarefa, marcar/desmarcar tarefa como concluída e remover uma tarefa.

O tutorial deve ser **totalmente ilustrado**, com **prints de tela para cada etapa** — desde a instalação das ferramentas até o primeiro login no app funcionando.

## 📝 **Descrição**&#x20;

Você deverá produzir um **tutorial passo a passo**, totalmente ilustrado, sobre:

✔ Criar um novo projeto Flutter

✔ Configurar o Flutter e validar a instalação

✔ Criar o projeto no Firebase Console

✔ Registrar o app Android ou iOS (pelo menos 1 deles)

✔ Integrar Firebase ao app (com prints de cada etapa)

✔ Configurar os pacotes Firebase no Flutter

✔ Criar telas simples: Login, Cadastro e Página interna

✔ Implementar Autenticação com Firebase Auth

✔ Salvar dados no Firestore

✔ Ler dados do Firestore e exibi-los na tela

✔ Rodar o aplicativo em dispositivo físico ou emulador

## 📢 **Instruções**

#### 📌 **Obrigatório: cada passo deve ter pelo menos 1 imagem ilustrativa.**

Pode ser:

* print do terminal
* print da IDE
* print do Firebase Console
* print do app rodando
* print do código na IDE

#### 📌 **Obrigatório: todo trecho de código deve conter duas explicações:**

1. **“O que esse código faz?”**
2. **“Por que esse código é necessário nesse passo?”**

#### 📌 **Formato da entrega:**

* Arquivo PDF
* Entre **10 e 20 páginas**
* Organização clara, com seções bem definidas

#### 📌 **O aluno DEVE produzir o próprio passo a passo**.

Não é permitido copiar tutoriais prontos — o professor irá verificar prints e coerência.

## 📄 Exemplo de como escrever

> #### **Passo 4 – Criando o projeto no Firebase Console**
>
> Acesse [https://console.firebase.google.com](https://console.firebase.google.com)
>
> 📸 _Print 4.1 – Tela do firebase console_
>
> Clique em **Adicionar Projeto**.
>
> 📸 _Print 4.2 – Tela de criação do projeto_
>
> Desative o Google Analytics (ou ative, se desejar).
>
> 📸 _Print 4.3 – Confirmação de projeto criado_
>
> Depois clique em **Adicionar app Android** e insira o applicationId.
>
> 📸 _Print 4.4 – Registro do app Android_
>
> (...)

> #### **Passo 7 – Implementando o cadastro de usuário**
>
> O código abaixo cria um novo usuário com e-mail e senha.
>
> ```dart
> await FirebaseAuth.instance
>     .createUserWithEmailAndPassword(
>         email: emailController.text,
>         password: senhaController.text,
>     );
> ```
>
> ✔ **O que esse código faz:**\
> Envia o e-mail e a senha para o Firebase Auth, criando uma nova conta no sistema.
>
> ✔ **Por que é necessário:**\
> Sem criar um usuário no backend, não é possível autenticar ninguém no aplicativo.
>
> 📸 _Print 7.1 – Conta criada no Firebase Console_\
> 📸 _Print 7.2 – Tela de cadastro funcionando no app_

