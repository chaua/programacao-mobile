import 'dart:async';
import 'package:floor/floor.dart';
import 'package:sqflite/sqflite.dart' as sqflite;
import 'shopping_model.dart';
import 'shopping_dao.dart';

part 'shopping_database.g.dart';

// Necessário executar o comando para gerar o código:
//dart run build_runner build --delete-conflicting-outputs

@Database(version: 1, entities: [ShoppingItem])
abstract class ShoppingDatabase extends FloorDatabase {
  ShoppingDao get shoppingDao;
}
