import 'package:flutter/material.dart';
import 'dart:math';

void main() {
  runApp(ExemploApp());
}

class ExemploApp extends StatelessWidget {
  // Lista de itens que será exibida no ListView
  var lista = [
    "🍍 Abacaxi",
    "🍎 Maçã",
    "🍈 Jaca",
    "🍉 Melancia",
    "🍌 Banana",
    "🍊 Laranja",
    "🍇 Uva",
    "🍐 Pera",
    "🥭 Manga",
    "🍒 Cereja",
    "🍓 Morango",
    "🥝 Kiwi",
    "🫐 Amora",
    "🌴 Coco",
    "🍋 Limão",
    "🍑 Pêssego",
    "🍍 Pitaya",
    "🍈 Melão",
    "🥥 Maracujá",
  ];

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text("Exemplo ListView Dinâmico"),
          centerTitle: true,
        ),

        body: ListView.separated(
          // Define o número de itens na lista
          itemCount: lista.length,

          // Função que constrói cada item da lista
          itemBuilder: (context, indice) {

            return ListTile(
              // Ícone ou imagem à esquerda do item
              leading: CircleAvatar(
                radius: 40,
                backgroundImage: NetworkImage(
                  "https://picsum.photos/200?random=${indice + 1}",
                ),
              ),

              // Título do item
              title: Text(lista[indice]),

              // Subtítulo do item
              subtitle: Text('Item da posição $indice'),

              // Ícone ou widget à direita do item
              trailing: Icon(
                indice % 3 == 0
                    ? Icons.favorite
                    : Icons.favorite_border_outlined,
                color: Colors.red,
              ),

              // Ação ao clicar no item
              onTap: () {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text("Cliquei em ${lista[indice]}")),
                );
              },
            );
          },

          separatorBuilder: (BuildContext context, int index) {
            return Divider();
          },
        ),
      ),
    );
  }
}
