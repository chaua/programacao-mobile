import 'dart:convert';

class ShoppingItem {
  final String name;

  ShoppingItem({required this.name});

  Map<String, dynamic> toJson() => {'name': name};

  factory ShoppingItem.fromJson(Map<String, dynamic> json) {
    return ShoppingItem(name: json['name']);
  }

  static List<ShoppingItem> decodeList(String jsonString) {
    final List<dynamic> data = json.decode(jsonString);
    return data.map((e) => ShoppingItem.fromJson(e)).toList();
  }

  static String encodeList(List<ShoppingItem> items) {
    return json.encode(items.map((e) => e.toJson()).toList());
  }
}
