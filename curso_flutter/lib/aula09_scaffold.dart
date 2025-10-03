import 'package:flutter/material.dart';

void main() {
  runApp(const MeuApp());
}

class MeuApp extends StatelessWidget {
  const MeuApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // Define o título do aplicativo
      title: 'Aula 10 - Scaffold',
      // Configura o tema do aplicativo com base em uma cor semente
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.green[900]!),
      ),
      // Define a tela inicial do aplicativo
      home: const TelaInicial(),
    );
  }
}

class TelaInicial extends StatelessWidget {
  const TelaInicial({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // ------------------------------------------------------------
      // region AppBar
      // Configura a barra superior da tela
      // ------------------------------------------------------------
      appBar: AppBar(
        elevation: 2.0, // Define a elevação (sombra) da barra
        shadowColor: Theme.of(context).colorScheme.shadow, // Cor da sombra
        title: const Text(
          "Minha Top Bar", // Título exibido na barra
          style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
        ),
        centerTitle: true, // Centraliza o título na barra
        actions: [
          IconButton(
            icon: const Icon(Icons.search), // Ícone de busca
            onPressed: () {
              debugPrint("Buscar pressionado!"); // Ação ao pressionar o botão
            },
          ),
          IconButton(
            icon: const Icon(Icons.more_vert), // Ícone de mais opções
            onPressed: () {
              debugPrint("Mais opções pressionado!"); // Ação ao pressionar o botão
            },
          ),
        ],
      ),
      // endregion

      // ------------------------------------------------------------
      // region Body
      // Define o corpo principal da tela
      // ------------------------------------------------------------
      body: const Center(
        child: Text(
          "Olá, este é o corpo da tela!", // Texto exibido no centro da tela
          style: TextStyle(fontSize: 20), // Estilo do texto
        ),
      ),
      // endregion

      // ------------------------------------------------------------
      // region FloatingActionButton
      // Adiciona um botão flutuante na tela
      // ------------------------------------------------------------
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          debugPrint("Botão Flutuante pressionado!"); // Ação ao pressionar o botão
        },
        child: const Icon(Icons.add), // Ícone exibido no botão
      ),
      // endregion

      // ------------------------------------------------------------
      // region BottomNavigationBar
      // Configura a barra de navegação inferior
      // ------------------------------------------------------------
      bottomNavigationBar: BottomNavigationBar(
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home), // Ícone da aba "Início"
            label: "Início", // Rótulo da aba
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person), // Ícone da aba "Perfil"
            label: "Perfil", // Rótulo da aba
          ),
        ],
      ),
      // endregion

      // ------------------------------------------------------------
      // region Drawer
      // Adiciona um menu lateral à tela
      // ------------------------------------------------------------
      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero, // Remove o padding padrão
          children: const [
            DrawerHeader(
              decoration: BoxDecoration(color: Colors.blue), // Fundo do cabeçalho
              child: Text(
                "Menu Lateral", // Texto do cabeçalho
                style: TextStyle(color: Colors.white), // Cor do texto
              ),
            ),
            ListTile(
              leading: Icon(Icons.settings), // Ícone da opção "Configurações"
              title: Text("Configurações"), // Texto da opção
            ),
            ListTile(
              leading: Icon(Icons.exit_to_app), // Ícone da opção "Sair"
              title: Text("Sair"), // Texto da opção
            ),
          ],
        ),
      ),
      // endregion
    );
  }
}