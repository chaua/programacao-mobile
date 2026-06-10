import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'shopping_model.dart';

class ShoppingController {
  final TextEditingController textController = TextEditingController();
  late final Box<ShoppingItem> shoppingBox;

  Future<void> init() async {
    shoppingBox = Hive.box<ShoppingItem>('shoppingBox');
  }

  List<ShoppingItem> get items => shoppingBox.values.toList();

  Future<void> addItem(Function() onUpdated) async {
    final name = textController.text.trim();
    if (name.isNotEmpty) {
      await shoppingBox.add(ShoppingItem(name: name));
      textController.clear();
      onUpdated();
    }
  }

  Future<void> removeItem(int index, Function() onUpdated) async {
    await shoppingBox.deleteAt(index);
    onUpdated();
  }

  void dispose() {
    textController.dispose();
  }
}
