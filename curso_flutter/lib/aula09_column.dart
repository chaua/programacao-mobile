import 'package:flutter/material.dart';

void main() {
  runApp(const MeuApp());
}

class MeuApp extends StatelessWidget {
  const MeuApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Exemplo de Column',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const TelaColumn(),
    );
  }
}

class TelaColumn extends StatelessWidget {
  const TelaColumn({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Exemplo de Column'),
        centerTitle: true,
      ),
      body: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              const Text(
                'Item 1',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              Container(
                color: Colors.red,
                height: 50,
                width: 50,
              ),
              const Text(
                'Item 2',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              Container(
                color: Colors.green,
                height: 50,
                width: 50,
              ),
              const Text(
                'Item 3',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              Container(
                color: Colors.blue,
                height: 50,
                width: 50,
              ),
            ],
          ),
        ],
      ),
    );
  }
}