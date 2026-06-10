import 'package:hive/hive.dart';

part 'shopping_model.g.dart';

// Adicionar as dependências no pubspec.yaml:
//
//dependencies:
//   flutter:
//     sdk: flutter
//   hive: ^2.2.3
//   hive_flutter: ^1.1.0
//
// dev_dependencies:
//   hive_generator: ^2.0.1
//   build_runner: ^2.4.7

// Depois de definir o modelo, precisa executar o comando:
// dart run build_runner build

/// aluno1
///   - calculo
///     - XYZ
///   - programacao
/// aluno2
///   - biologia
///   - calculo
///     - XYZ
/// aluno3

@HiveType(typeId: 0)
class ShoppingItem extends HiveObject {
  @HiveField(0)
  String name;

  ShoppingItem({required this.name});
}
