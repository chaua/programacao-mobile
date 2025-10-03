import 'package:flutter/material.dart';

void main() {
  runApp(ExemploApp());
}

class ExemploApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Exemplo de ListView"),
          centerTitle: true,
        ),
        body: ListView(
          // O ListView é um widget usado para criar listas roláveis.
          // Ele é ideal para exibir uma grande quantidade de itens.
          children: [
            // Adicionando um texto simples como item da lista
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Text(
                "Exemplo de ListView com Flutter",
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                textAlign: TextAlign.center,
              ),
            ),

            // Adicionando um ListTile como item da lista
            ListTile(
              leading: Icon(Icons.home, color: Colors.blue),
              title: Text("Home"),
              subtitle: Text("Tela inicial do aplicativo"),
              onTap: () {
                // Ação ao clicar no item
                print("Clicou em Home");
              },
            ),

            // Outro ListTile com ícone e texto
            ListTile(
              leading: Icon(Icons.cake, color: Colors.pink),
              title: Text("Cake"),
              subtitle: Text("Tela de bolos do aplicativo"),
              onTap: () {
                print("Clicou em Cake");
              },
            ),

            // Gerando itens dinamicamente com um loop
            for (var i = 0; i < 10; i++)
              ListTile(
                leading: Icon(Icons.dark_mode_rounded, color: Colors.grey),
                title: Text("Lua $i"),
                subtitle: Text("Tela lua número $i"),
                onTap: () {
                  print("Clicou na Lua $i");
                },
              ),
          ],
        ),
      ),
    );
  }
}