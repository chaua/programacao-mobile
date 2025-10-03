import 'package:flutter/material.dart';

void main() {
  runApp(ExemploApp());
}

class ExemploApp extends StatelessWidget {
  // Lista de itens que será exibida no GridView
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
          title: const Text("Exemplo GridView Dinâmico"),
          centerTitle: true,
        ),
        body: GridView.builder(
          gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 2, // Número de colunas
            crossAxisSpacing: 10, // Espaçamento horizontal
            mainAxisSpacing: 10, // Espaçamento vertical
          ),
          itemCount: lista.length,
          padding: const EdgeInsets.all(10),
          itemBuilder: (context, indice) {
            return GestureDetector(
              onTap: () {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text("Cliquei em ${lista[indice]}")),
                );
              },
              child:  Card(
                elevation: 5,
                clipBehavior: Clip.antiAlias,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(8),
                ),
                child: Stack(
                  children: [
                    Image.network(
                      "https://picsum.photos/200/300?random=${indice + 1}",
                      fit: BoxFit.cover,
                      height: (indice % 3 + 1) * 100, // Altura variável
                      width: double.infinity,
                    ),
                    Positioned(
                      bottom: 0,
                      left: 0,
                      right: 0,
                      child: Container(
                        color: Colors.black.withOpacity(0.6),
                        padding: const EdgeInsets.all(8.0),
                        child: Text(
                          lista[indice],
                          style: const TextStyle(
                            fontSize: 16,
                            fontWeight: FontWeight.bold,
                            color: Colors.white,
                          ),
                          textAlign: TextAlign.center,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            );
          },
        ),
      ),
    );
  }
}