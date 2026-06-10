import 'package:cloud_firestore/cloud_firestore.dart';
import 'shopping_model.dart';

class ShoppingFirestoreController {

  // Recupera uma instância da coleção que queremos trabalhar
  final _collection = FirebaseFirestore.instance.collection('compras');

  Stream<List<ShoppingItem>> getItems() {
    return _collection.snapshots().map((snapshot) {
      return snapshot.docs.map((doc) {
        return ShoppingItem.fromFirestore(doc.data(), doc.id);
      }).toList();
    });
  }

  Future<void> addItem(String name) async {
    if (name.trim().isEmpty) return;
    await _collection.add({'name': name});
  }

  Future<void> deleteItem(String id) async {
    await _collection.doc(id).delete();
  }
}
