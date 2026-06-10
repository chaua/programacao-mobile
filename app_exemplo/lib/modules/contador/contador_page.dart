import 'package:flutter/material.dart';

class ContadorPage extends StatefulWidget {

  ContadorPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _ContadorState();
  }
}

class _ContadorState extends State<StatefulWidget> {
  int _contador = 0;

  void _incrementarContador() {
    print('Incrementando valor: $_contador');

    setState(() {
      _contador++;
    });

    print('Novo valor: $_contador');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Contador'),
      ),

      body: Center(
        child: Text('Contador: $_contador'),
      ),

      floatingActionButton: FloatingActionButton(onPressed: _incrementarContador),


    );
  }

}