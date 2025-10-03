import 'package:flutter/material.dart';

void main() {
  runApp(const MeuApp());
}

class MeuApp extends StatelessWidget {
  const MeuApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Exemplo de Margin e Padding',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const TelaMarginPadding(),
    );
  }
}

class TelaMarginPadding extends StatelessWidget {
  const TelaMarginPadding({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Exemplo de Margin e Padding'),
        centerTitle: true,
      ),
      body: Center(
        child: Container(
          margin: const EdgeInsets.all(20), // Espaço externo ao redor do container
          padding: const EdgeInsets.all(15), // Espaço interno dentro do container
          decoration: BoxDecoration(
            color: Colors.blue[100], // Cor de fundo do container
            border: Border.all(color: Colors.blue, width: 2), // Borda do container
          ),
          child: const Text(
            'Exemplo de Margin e Padding',
            style: TextStyle(fontSize: 18),
            textAlign: TextAlign.center,
          ),
        ),
      ),
    );
  }
}