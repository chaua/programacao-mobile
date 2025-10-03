import 'package:flutter/material.dart';

void main() {
  runApp(const MeuApp());
}

class MeuApp extends StatelessWidget {
  const MeuApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Exemplo de Row',
      theme: ThemeData(primarySwatch: Colors.yellow),
      home: const TelaRow(),
    );
  }
}

class TelaRow extends StatelessWidget {
  const TelaRow({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Exemplo de Row'),
        centerTitle: true,
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          // Exemplo básico de Row
          const Text(
            'Exemplo Básico:',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          Row(
            children: const [
              Icon(Icons.star, color: Colors.red),
              Icon(Icons.star, color: Colors.green),
              Icon(Icons.star, color: Colors.blue),
            ],
          ),
          const SizedBox(height: 20),

          // Row com espaçamento entre os itens
          const Text(
            'MainAxisAlignment.spaceBetween:',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: const [
              Icon(Icons.star, color: Colors.red),
              Icon(Icons.star, color: Colors.green),
              Icon(Icons.star, color: Colors.blue),
            ],
          ),
          const SizedBox(height: 20),

          // Row com alinhamento central
          const Text(
            'CrossAxisAlignment.center:',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          Row(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Container(
                color: Colors.red,
                height: 50,
                width: 50,
              ),
              Container(
                color: Colors.green,
                height: 100,
                width: 50,
              ),
              Container(
                color: Colors.blue,
                height: 75,
                width: 50,
              ),
            ],
          ),
          const SizedBox(height: 20),

          // Row com espaçamento uniforme
          const Text(
            'MainAxisAlignment.spaceEvenly:',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: const [
              Icon(Icons.star, color: Colors.red),
              Icon(Icons.star, color: Colors.green),
              Icon(Icons.star, color: Colors.blue),
            ],
          ),
          const SizedBox(height: 20),

          // Row com itens esticados
          const Text(
            'MainAxisSize.max:',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          Row(
            mainAxisSize: MainAxisSize.max,
            children: [
              Expanded(
                child: Container(
                  color: Colors.red,
                  height: 50,
                ),
              ),
              Expanded(
                child: Container(
                  color: Colors.green,
                  height: 50,
                ),
              ),
              Expanded(
                child: Container(
                  color: Colors.blue,
                  height: 50,
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}