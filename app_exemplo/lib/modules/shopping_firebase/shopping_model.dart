class ShoppingItem {
  final String id;
  final String name;

  ShoppingItem({required this.id, required this.name});

  factory ShoppingItem.fromFirestore(Map<String, dynamic> data, String id) {
    return ShoppingItem(id: id, name: data['name']);
  }

}
