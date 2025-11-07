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

# Tutorial firebase

{% hint style="info" %}
**Documentação oficial**

[https://firebase.google.com/docs/flutter/setup?hl=pt-br\&platform=ios](https://firebase.google.com/docs/flutter/setup?hl=pt-br\&platform=ios)\
\
**Tutorial passo a passo**

[https://medium.com/@ianoliveirag12/configurando-o-firebase-no-flutter-dfd71438d6ce](https://medium.com/@ianoliveirag12/configurando-o-firebase-no-flutter-dfd71438d6ce)
{% endhint %}

## 1️⃣ Criar o projeto Flutter

```bash
flutter create firebase_demo
cd firebase_demo
```

Abra no editor e rode para conferir:

```bash
flutter run
```

## 2️⃣ Criar o projeto no Firebase

1. Acesse o **Firebase Console** → "Adicionar projeto".
2. Nome do projeto: `firebase_demo` (qualquer nome serve).
3. Desative o Google Analytics por enquanto (pode ativar depois).
4. Criar.

## 3️⃣ Conectar o app Flutter ao Firebase (FlutterFire CLI)

> Método recomendado para evitar erros de configuração.

Instale o CLI (se ainda não tiver):

```bash
dart pub global activate flutterfire_cli
```

Logue no Firebase (se pedir):

```bash
firebase login
```

No diretório do app:

```bash
flutterfire configure
```

* Selecione seu projeto Firebase.
* Marque as plataformas (Android e iOS, se for usar).
* O comando gera `firebase_options.dart` em `lib/`.

## 4️⃣ Adicionar dependências no Flutter

No `pubspec.yaml`:

```yaml
dependencies:
  flutter:
    sdk: flutter
  firebase_core: ^3.6.0
  cloud_firestore: ^5.4.4
```

Instale:

```bash
flutter pub get
```

## 5️⃣ Inicializar o Firebase no app

Edite `lib/main.dart`:

```dart
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'firebase_options.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Inicializa o Firebase com as opções geradas pelo FlutterFire
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );

  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Firestore Demo',
      theme: ThemeData(useMaterial3: true),
      home: const MessagePage(),
    );
  }
}
```

## 6️⃣ Modelar dados

Vamos criar uma coleção `messages` com documentos contendo:

```json
{
  "text": "Olá Firebase!",
  "createdAt": <Timestamp do servidor>
}
```

## 7️⃣ Escrever (enviar) valores para o Firestore

Crie `lib/message_page.dart` (ou no mesmo arquivo, se preferir). Aqui vai tudo junto para simplicidade:

```dart
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';

class MessagePage extends StatefulWidget {
  const MessagePage({super.key});

  @override
  State<MessagePage> createState() => _MessagePageState();
}

class _MessagePageState extends State<MessagePage> {
  final _controller = TextEditingController();
  final _messagesRef = FirebaseFirestore.instance.collection('messages');

  Future<void> _send() async {
    final text = _controller.text.trim();
    if (text.isEmpty) return;

    await _messagesRef.add({
      'text': text,
      'createdAt': FieldValue.serverTimestamp(), // timestamp do servidor
    });

    _controller.clear();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Firestore - Enviar/Receber')),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            // Campo de entrada + botão salvar (ENVIAR)
            Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: _controller,
                    decoration: const InputDecoration(
                      labelText: 'Digite uma mensagem',
                      border: OutlineInputBorder(),
                    ),
                    onSubmitted: (_) => _send(),
                  ),
                ),
                const SizedBox(width: 8),
                FilledButton(
                  onPressed: _send,
                  child: const Text('Salvar'),
                ),
              ],
            ),
            const SizedBox(height: 16),

            // Lista em tempo real (RECEBER)
            Expanded(
              child: StreamBuilder<QuerySnapshot<Map<String, dynamic>>>(
                stream: _messagesRef
                    .orderBy('createdAt', descending: true)
                    .snapshots(),
                builder: (context, snapshot) {
                  if (snapshot.hasError) {
                    return Text('Erro: ${snapshot.error}');
                  }
                  if (!snapshot.hasData) {
                    return const Center(child: CircularProgressIndicator());
                  }

                  final docs = snapshot.data!.docs;

                  if (docs.isEmpty) {
                    return const Center(child: Text('Sem mensagens ainda'));
                  }

                  return ListView.separated(
                    itemCount: docs.length,
                    separatorBuilder: (_, __) => const Divider(height: 1),
                    itemBuilder: (context, index) {
                      final data = docs[index].data();
                      final text = data['text'] as String? ?? '';
                      final createdAt = data['createdAt']; // pode ser null até o server preencher
                      return ListTile(
                        title: Text(text),
                        subtitle: Text(
                          createdAt == null
                              ? 'Enviando...'
                              : (createdAt as Timestamp)
                                  .toDate()
                                  .toLocal()
                                  .toString(),
                          maxLines: 1,
                          overflow: TextOverflow.ellipsis,
                        ),
                      );
                    },
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
```

> O botão **Salvar** chama `_send()`, que faz `add()` na coleção — isso **envia** o valor.
>
> A `StreamBuilder` usa `snapshots()` — isso **recebe** atualizações em tempo real (toda mudança na coleção reflete na UI).

## 8️⃣ Regras de segurança

No **Firestore** → **Rules**, para testes locais rápidos você pode usar algo **aberto** enquanto desenvolve **(NÃO use em produção)**:

```
// NÃO usar em produção
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if true; // aberto
    }
  }
}
```

Depois, evolua para algo mais responsável (ex.: exigir login com Firebase Auth ou restringir campos/coleções).

## 9️⃣ Executar e testar

1. Rode o app: `flutter run`.
2. Digite uma mensagem e toque **Salvar**.
3. Veja a lista ser atualizada imediatamente (stream).

## 1️⃣0️⃣ Atualizar e apagar

*   **Update**:

    ```dart
    await _messagesRef.doc(id).update({'text': 'novo valor'});
    ```
*   **Delete**:

    ```dart
    await _messagesRef.doc(id).delete();
    ```

Você pega o `id` com `docs[index].id`.

## 1️⃣1️⃣ Boas práticas

* Use `FieldValue.serverTimestamp()` para ordenação por tempo confiável.
* Para arquitetura maior, extraia o acesso a dados para um `Repository/Service`.
* Em produção, **NUNCA** deixe regras abertas; use Auth + regras específicas.

## &#x20;1️⃣2️⃣ Erros comuns e como resolver

* **\[core/no-app]**: esqueceu de chamar `Firebase.initializeApp(...)`.
* **Permissão negada**: regras bloqueando; abra temporariamente (modo estudo) ou faça login com Auth.
* **Coleção vazia sem UI**: trate `docs.isEmpty` (como no exemplo).
* **Ordenação por `createdAt` falhando**: alguns docs ficam sem timestamp enquanto o server preenche — trate `null` no UI.

