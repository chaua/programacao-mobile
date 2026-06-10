// lib/app/app_widget.dart
import 'package:flutter/material.dart';
import 'app_routes.dart';

class AppWidget extends StatelessWidget {
  final Map<String, WidgetBuilder> _rotas;

  const AppWidget(this._rotas, {super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'App Template',
        debugShowCheckedModeBanner: false,
      // Define o tema da aplicação
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue[500]!),
      ),

      // Define qual será a tela inicial
      initialRoute: AppRoutes.home,

      // Define todas as rotas da aplicação
      routes: _rotas,
    );
  }
}