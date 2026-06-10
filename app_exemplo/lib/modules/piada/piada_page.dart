import 'dart:convert';

import 'package:app_exemplo/shared/widgets/my_app_bar.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:translator/translator.dart';

class PiadaPage extends StatefulWidget {
  PiadaPage({super.key});

  @override
  State<StatefulWidget> createState() => _PiadaState();
}

class _PiadaState extends State<PiadaPage> {
  // Armazenam o valor que será exibido na tela
  String? _piada;

  // Biblioteca para traduzir
  GoogleTranslator translator = GoogleTranslator();

  // Controla o loading
  bool _carregando = false;

  Future<String> _traduzir(String texto) async {
    var traducao = await translator.translate(texto, from: 'en', to: 'pt');
    return traducao.text;
  }

  Future<void> _getPiada() async {
    setState(() {
      _carregando = true;
    });

    // Realiza a chamada para a API de piadas
    var url = Uri.parse('https://v2.jokeapi.dev/joke/Any?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=single',);

    // Espera pela resposta
    var resposta = await http.get(url);

    // Status HTTP = 200 -> Sucesso
    if (resposta.statusCode == 200) {
      // Decodifica o body que está em formato JSON para um Dicionário/Mapa
      var dados = jsonDecode(resposta.body);

      // Verifica se veio uma piada simples
      var traducaoPiada = await _traduzir(dados['joke'] ?? '');

      setState(() {
        _piada = traducaoPiada;
        _carregando = false;
      });
    } else {
      setState(() {
        _piada = "Piada não encontrada! 🤡";
        _carregando = false;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: MyAppBar(context: context),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(24.0),
          child:
              _carregando
                  ? CircularProgressIndicator()
                  : Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text(
                        _piada ?? '',
                        textAlign: TextAlign.left,
                        style: TextStyle(
                          fontSize: 20,
                        ),
                      ),

                      SizedBox(height: 32),

                      ElevatedButton.icon(
                        onPressed: _getPiada,
                        icon: Icon(Icons.casino_outlined),
                        label: Text('Nova piada'),
                        style: ElevatedButton.styleFrom(
                          padding: EdgeInsets.symmetric(
                            horizontal: 24,
                            vertical: 16,
                          ),
                          textStyle: TextStyle(fontSize: 16),
                        ),
                      ),
                    ],
                  ),
        ),
      ),
    );
  }
}
