import 'package:flutter/material.dart';

void main() {
  runApp(NavegacaoNomeada());
}

class NavegacaoNomeada extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var rotas = {
      "/": (context) => TelaPrincipal(),
      "/tela2": (context) => SegundaTela(),
      "/tela3": (context) => TerceiraTela(),
    };

    return MaterialApp(
      routes: rotas,
      initialRoute: "/",
    );
  }
}

class TelaPrincipal extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Tela Principal"),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton.icon(
              onPressed: () {
                Navigator.pushNamed(context, "/tela2");
              },
              icon: const Icon(Icons.navigate_next),
              label: const Text("Ir para Tela 2"),
            ),
            const SizedBox(height: 20),
            ElevatedButton.icon(
              onPressed: () {
                Navigator.pushNamed(
                  context,
                  "/tela3",
                  arguments: Pessoa("Mulher Maravilha", 30),
                );
              },
              icon: const Icon(Icons.person),
              label: const Text("Ir para Tela 3"),
            ),
          ],
        ),
      ),
    );
  }
}

class SegundaTela extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Segunda Tela"),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const Text(
              "Bem-vindo à Tela 2!",
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),
            Image.network(
              "https://picsum.photos/200",
              height: 150,
              width: 150,
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () => Navigator.pop(context),
              child: const Text("Voltar"),
            ),
          ],
        ),
      ),
    );
  }
}

class TerceiraTela extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final pessoa =
        ModalRoute.of(context)?.settings.arguments as Pessoa ??
            Pessoa("Desconhecido", 0);

    return Scaffold(
      appBar: AppBar(
        title: const Text("Terceira Tela"),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text(
              "Olá, ${pessoa.nome}!",
              style: const TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 10),
            Text(
              "Idade: ${pessoa.idade}",
              style: const TextStyle(fontSize: 18),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () => Navigator.pop(context),
              child: const Text("Voltar"),
            ),
          ],
        ),
      ),
    );
  }
}

class Pessoa {
  final String nome;
  final int idade;

  Pessoa(this.nome, this.idade);
}