import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(home: NavegacaoSimples()));
}

class NavegacaoSimples extends StatelessWidget {
  const NavegacaoSimples({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Navegação Simples"),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text(
              "Bem-vindo!",
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),
            ElevatedButton.icon(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => SegundaTela()),
                );
              },
              icon: const Icon(Icons.navigate_next),
              label: const Text("Ir para tela 2"),
            ),
            const SizedBox(height: 10),
            ElevatedButton.icon(
              onPressed: () async {
                final resultado = await Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) =>
                        TerceiraTela(mensagem: "Digite sua mensagem!"),
                  ),
                );

                if (resultado != null) {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(content: Text("Mensagem recebida: $resultado")),
                  );
                }
              },
              icon: const Icon(Icons.message),
              label: const Text("Ir para tela 3"),
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
              "Imagem Centralizada",
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
              onPressed: () {
                Navigator.pop(context);
              },
              child: const Text("Voltar"),
            ),
          ],
        ),
      ),
    );
  }
}

class TerceiraTela extends StatelessWidget {
  final String mensagem;

  TerceiraTela({super.key, required this.mensagem});

  @override
  Widget build(BuildContext context) {
    final TextEditingController controlador = TextEditingController();

    return Scaffold(
      appBar: AppBar(
        title: const Text("Terceira Tela"),
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              mensagem,
              style: const TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),
            TextField(
              controller: controlador,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                labelText: "Digite algo",
              ),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context, controlador.text);
              },
              child: const Text("Enviar e Voltar"),
            ),
          ],
        ),
      ),
    );
  }
}