import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'shopping_model.dart';

// Shared Preferences
// > Armazenamento de dados simples: int, float, boolean, String
// > Armazenar dados configurações, preferências
// > Não é recomendado armazenar grandes volumes de dados

class ShoppingController {
  final TextEditingController textController = TextEditingController();
  List<ShoppingItem> items = [];

  Future<void> loadItems(Function(List<ShoppingItem>) onLoaded) async {
    final prefs = await SharedPreferences.getInstance(); // Singleton
    final jsonString = prefs.getString('shopping_list');
    if (jsonString != null) {
      items = ShoppingItem.decodeList(jsonString);
    }
    onLoaded(items);
  }

  Future<void> addItem(Function(List<ShoppingItem>) onUpdated) async {
    final name = textController.text.trim();
    if (name.isEmpty) return;
    final item = ShoppingItem(name: name);
    items.add(item);
    await _saveItems();
    onUpdated(items);
  }

  Future<void> removeItem(int index, Function(List<ShoppingItem>) onUpdated) async {
    items.removeAt(index);
    await _saveItems();
    onUpdated(items);
  }

  Future<void> _saveItems() async {
    final prefs = await SharedPreferences.getInstance();
    final jsonString = ShoppingItem.encodeList(items);
    await prefs.setString('shopping_list', jsonString);
  }

  void dispose() {
    textController.dispose();
  }
}
