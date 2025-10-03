// import: lista de todas bibliotecas que serão usadas
import 'package:flutter/material.dart';

// Ponto de entrada de qualquer programa Dart
void main() {
  // Função indica qual será a aplicação que queremos executar
  // - Recebe um Widget como parametro
  // - No flutter tudo é um widget
  runApp(HelloApp());
}

// Temos dois tipos:
//    StatelessWidget: não mantém estado interno
//    StatefulWidget: mantém estado interno - possui conjunto de variáveis que
//                    retem valores com o passar do tempo
class HelloApp extends StatelessWidget {
  // Função build sempre deverá ser sobrescrita
  // - Retorna a árvore de widgets que representam a minha tela
  @override
  Widget build(BuildContext context) {
    // Os widgets podem representar um:
    //    - container: usado para organizar os widgets internos
    //    - componentes: usados para interação com o usuários

    // Center: Container que centraliza o filho

    return MaterialApp(
      // Define uma estrutura padrão de tela
      // - home: área principal
      // - appBar: barra superior do app
      // - bottomNavigationBar: barra inferior de ações
      // - drawer: menu lateral de ações
      // - floatingActionButton: botão flutuante de ações
      home: Scaffold(
        // Barra superior
        appBar: AppBar(
          title: Center(child: Text("App Flutter")),
          actions: [
            IconButton(onPressed: () {}, icon: Icon(Icons.account_circle)),
            IconButton(onPressed: () {}, icon: Icon(Icons.add_circle)),
          ],
        ),

        // Bottom navigation
        bottomNavigationBar: BottomNavigationBar(
          items: [
            BottomNavigationBarItem(
              icon: Icon(Icons.child_care_sharp),
              label: "Home",
            ),
            BottomNavigationBarItem(icon: Icon(Icons.rocket), label: "Foguete"),
            BottomNavigationBarItem(
              icon: Icon(Icons.beach_access_outlined),
              label: "Praia",
            ),
          ],
        ),

        floatingActionButton: FloatingActionButton(
          onPressed: () {},
          child: Icon(Icons.search),
        ),

        // Menu lateral
        drawer: Drawer(
          child: ListView(
            padding: EdgeInsets.all(16.0),
            children: [
              DrawerHeader(child: Text("Menu")),
              ListTile(title: Text("Item1")),
              ListTile(title: Text("Item1")),
            ],
          ),
        ),

        // Layouts basicos
        // - Row: Organiza os filhos na mesma linha (hoRizontal)
        // - Column: Organiza os filhos na mesma coluna (verticaL)

        // O alinhamento dos filhos é feito com base nos eixos
        //  mainAxisAlignment
        //      Row: horizontal
        // No Row:
        // start: alinha a esquerda
        // end: alinha a direita
        // center: centraliza
        // spaceBetween: distribui espaco igualmente entre os filhos
        // spaceAround: distribui espaco em volta
        // spaceEvenly: distribui espacos iguais

        // Área principal do aplicativo
        body: Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,

          // Lista de widgets
          children: [
            Text("Elemento 1"),
            Text("Elemento 2"),
            Text("Elemento 3"),

            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,

              children: [Text("Item 1"), Text("Item 2"), Text("Item 3")],
            ),

            // Exemplo de cartao
            // (  )    Nome
            //         Profissao
            Row(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                // Foto redonda
                Container(
                  margin: EdgeInsets.all(16),
                  child: CircleAvatar(
                    radius: 40,
                    backgroundImage: NetworkImage("https://picsum.photos/200"),
                  ),
                ),

                // Nome e profissão
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "Nome do Fulano",
                        style: TextStyle(
                          color: Colors.black,
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      SizedBox(height: 4),
                      Text(
                        "Profissão",
                        style: TextStyle(
                          color: Colors.grey[600],
                          fontSize: 14,
                        ),
                      ),

                      // Botões (like e compartilhar)
                      Row(
                        mainAxisAlignment: MainAxisAlignment.end,
                        children: [
                          IconButton(
                            icon: Icon(Icons.thumb_up_alt_outlined, color: Colors.grey[700]),
                            onPressed: () {},
                          ),
                          IconButton(
                            icon: Icon(Icons.share_outlined, color: Colors.grey[700]),
                            onPressed: () {},
                          ),
                        ],
                      ),




                    ],
                  ),
                ),

              ],
            )




          ],
        ),
      ),
    );
  }
}
