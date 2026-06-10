import 'package:app_exemplo/modules/shopping_firebase/shopping_page.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

import '../modules/contador/contador_page.dart';
import '../modules/home/home_page.dart';
import '../modules/piada/piada_page.dart';
import '../modules/semaforo/semaforo_page.dart';
import '../modules/shopping_floor/shopping_controller.dart';
import '../modules/shopping_floor/shopping_database.dart';
import '../modules/shopping_floor/shopping_page.dart';
import '../modules/shopping_hive/shopping_page.dart';
import '../modules/shopping_shared/shopping_page.dart';

class AppRoutes {
  // Nomes das rotas
  static const String home = '/';
  static const String shoppingShared = '/shoppingSharedList';
  static const String shoppingHive = '/shoppingHive';
  static const String shoppingFloor = '/shoppingFloor';
  static const String shoppingFirebase = '/shoppingFirebase';
  static const String piada = '/piada';
  static const String contador = '/contador';
  static const String semaforo = '/semaforo';

  // Gera dinamicamente as rotas com dependências resolvidas
  static Future<Map<String, WidgetBuilder>> getRoutes() async {

    ShoppingController? controller;

    if (!kIsWeb) {
      final db =
      await $FloorShoppingDatabase
          .databaseBuilder('shopping_database.db')
          .build();
      controller = ShoppingController(db.shoppingDao);
    }
    return {
      home: (context) => const HomePage(),
      contador: (context) => ContadorPage(),
      piada: (context) => PiadaPage(),
      semaforo: (context) => SemaforoPage(),
      shoppingShared: (context) => const ShoppingSharedPage(),
      shoppingHive: (context) => const ShoppingHivePage(),
      shoppingFloor: (context) => ShoppingFloorPage(controller: controller),
      shoppingFirebase: (context) => ShoppingFirestorePage(),
    };
  }
}
