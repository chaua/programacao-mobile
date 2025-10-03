import 'package:flutter/material.dart';
import 'package:flutter_staggered_grid_view/flutter_staggered_grid_view.dart';

void main() {
  runApp(ExemploApp());
}

class ExemploApp extends StatelessWidget {
  final lista = [
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
          title: const Text("Exemplo Grid Escalonado"),
          centerTitle: true,
        ),
        body: Padding(
          padding: const EdgeInsets.all(8.0),
          child: MasonryGridView.builder(
            gridDelegate: const SliverSimpleGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 2, // Número de colunas
            ),
            itemCount: lista.length,
            mainAxisSpacing: 10,
            crossAxisSpacing: 10,
            itemBuilder: (context, indice) {
              return Card(
                elevation: 5,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: [
                    ClipRRect(
                      borderRadius: const BorderRadius.vertical(top: Radius.circular(8)),
                      child: Image.network(
                        "https://picsum.photos/200/300?random=${indice + 1}",
                        fit: BoxFit.cover,
                        height: (indice % 3 + 1) * 100, // Altura variável
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Text(
                        lista[indice],
                        style: const TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.bold,
                        ),
                        textAlign: TextAlign.center,
                      ),
                    ),
                  ],
                ),
              );
            },
          ),
        ),
      ),
    );
  }
}