import 'package:flutter/material.dart';
import 'shopping_controller.dart';
import 'shopping_model.dart';

class ShoppingFirestorePage extends StatefulWidget {
  const ShoppingFirestorePage({super.key});

  @override
  State<ShoppingFirestorePage> createState() => _ShoppingFirestorePageState();
}

class _ShoppingFirestorePageState extends State<ShoppingFirestorePage> {
  final ShoppingFirestoreController controller = ShoppingFirestoreController();
  final TextEditingController _textController = TextEditingController();

  void _addItem() {
    controller.addItem(_textController.text);
    _textController.clear();
  }

  void _deleteItem(String id) {
    controller.deleteItem(id);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Lista de Compras (Firestore)')),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(16),
            child: Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: _textController,
                    decoration: const InputDecoration(labelText: 'Novo item'),
                  ),
                ),
                IconButton(
                  icon: const Icon(Icons.add),
                  onPressed: _addItem,
                ),
              ],
            ),
          ),
          Expanded(
            child: StreamBuilder<List<ShoppingItem>>(
              stream: controller.getItems(),
              builder: (context, snapshot) {
                if (snapshot.hasError) {
                  return const Center(child: Text('Erro ao carregar os dados.'));
                }
                if (!snapshot.hasData) {
                  return const Center(child: CircularProgressIndicator());
                }

                final items = snapshot.data!;
                if (items.isEmpty) {
                  return const Center(child: Text('Nenhum item na lista.'));
                }

                return ListView.builder(
                  itemCount: items.length,
                  itemBuilder: (context, index) {
                    final item = items[index];
                    return ListTile(
                      title: Text(item.name),
                      trailing: IconButton(
                        icon: const Icon(Icons.delete),
                        onPressed: () => _deleteItem(item.id),
                      ),
                    );
                  },
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}
