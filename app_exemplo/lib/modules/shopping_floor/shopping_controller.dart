import 'package:flutter/material.dart';
import 'shopping_model.dart';
import 'shopping_dao.dart';

class ShoppingController {
  final TextEditingController textController = TextEditingController();
  final ShoppingDao dao;
  List<ShoppingItem> items = [];

  ShoppingController(this.dao);

  Future<void> loadItems(Function() onUpdated) async {
    items = await dao.findAllItems();
    onUpdated();
  }

  Future<void> addItem(Function() onUpdated) async {
    final name = textController.text.trim();
    if (name.isNotEmpty) {
      await dao.insertItem(ShoppingItem(name: name));
      textController.clear();
      await loadItems(onUpdated);
    }
  }

  Future<void> deleteItem(ShoppingItem item, Function() onUpdated) async {
    await dao.deleteItem(item);
    await loadItems(onUpdated);
  }

  void dispose() {
    textController.dispose();
  }
}
