import 'package:flutter/material.dart';

void main() {
  runApp(const MeuApp());
}

class MeuApp extends StatelessWidget {
  const MeuApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Exemplo de Container',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const TelaContainer(),
    );
  }
}

class TelaContainer extends StatelessWidget {
  const TelaContainer({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Exemplo de Container'),
        centerTitle: true,
      ),
      body: Center(
        child: Container(
          width: 200, // Largura do container
          height: 200, // Altura do container
          alignment: Alignment.center, // Alinhamento do conteúdo interno
          decoration: BoxDecoration(
            color: Colors.blue, // Cor de fundo
            border: Border.all(color: Colors.black, width: 3), // Borda
            borderRadius: BorderRadius.circular(15), // Bordas arredondadas
            boxShadow: const [
              BoxShadow(
                color: Colors.grey, // Cor da sombra
                blurRadius: 10, // Raio do desfoque
                offset: Offset(5, 5), // Deslocamento da sombra
              ),
            ],
            gradient: const LinearGradient(
              colors: [Colors.blue, Colors.lightBlueAccent], // Gradiente
              begin: Alignment.topLeft,
              end: Alignment.bottomRight,
            ),
          ),
          child: const Text(
            'Exemplo',
            style: TextStyle(
              color: Colors.white, // Cor do texto
              fontSize: 20, // Tamanho da fonte
              fontWeight: FontWeight.bold, // Peso da fonte
            ),
          ),
        ),
      ),
    );
  }
}