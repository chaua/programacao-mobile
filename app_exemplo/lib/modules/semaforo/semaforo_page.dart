import 'package:flutter/material.dart';

class SemaforoPage extends StatefulWidget {
  SemaforoPage({super.key});

  @override
  State<StatefulWidget> createState() => _SemaforoState();
}

class _SemaforoState extends State<SemaforoPage> {
  Color _corBotao1 = Colors.grey;
  Color _corBotao2 = Colors.grey;
  Color _corBotao3 = Colors.grey;

  void _ligarVerde() {
    setState(() {
      _corBotao1 = Colors.green;
      _corBotao2 = Colors.grey;
      _corBotao3 = Colors.grey;
    });
  }

  void _ligarAmarelo() {
    setState(() {
      _corBotao1 = Colors.grey;
      _corBotao2 = Colors.amber;
      _corBotao3 = Colors.grey;
    });
  }

  void _ligarVermelho() {
    setState(() {
      _corBotao1 = Colors.grey;
      _corBotao2 = Colors.grey;
      _corBotao3 = Colors.red;
    });
  }
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: _ligarVerde,
              style: ElevatedButton.styleFrom(backgroundColor: _corBotao1),
              child: Text('Botão 1'),
            ),
            SizedBox(height: 16),
            ElevatedButton(
              onPressed: _ligarAmarelo,
              style: ElevatedButton.styleFrom(backgroundColor: _corBotao2),
              child: Text('Botão 2'),
            ),
            SizedBox(height: 16),
            ElevatedButton(
              onPressed: _ligarVermelho,
              style: ElevatedButton.styleFrom(backgroundColor: _corBotao3),
              child: Text('Botão 3'),
            ),
          ],
        ),
      ),
    );
  }
}
