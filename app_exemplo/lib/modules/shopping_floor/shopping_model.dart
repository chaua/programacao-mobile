import 'package:floor/floor.dart';

@entity
class ShoppingItem {
  @PrimaryKey(autoGenerate: true)
  final int? id;

  final String name;

  ShoppingItem({this.id, required this.name});
}

// Adicionar as dependências no pubspec.yaml: