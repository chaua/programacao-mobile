import 'package:flutter/material.dart';
import 'shopping_controller.dart';
import 'shopping_model.dart';

class ShoppingSharedPage extends StatefulWidget {
  const ShoppingSharedPage({super.key});

  @override
  State<ShoppingSharedPage> createState() => _ShoppingPageState();
}

class _ShoppingPageState extends State<ShoppingSharedPage> {
  final ShoppingController controller = ShoppingController();

  @override
  void initState() {
    super.initState();
    controller.loadItems((loadedItems) {
      setState(() {});
    });
  }

  @override
  void dispose() {
    controller.dispose();
    super.dispose();
  }

  void _addItem() {
    controller.addItem((updatedItems) {
      controller.textController.clear();
      setState(() {});
    });
  }

  void _removeItem(int index) {
    controller.removeItem(index, (updatedItems) {
      setState(() {});
    });
  }

  @override
  Widget build(BuildContext context) {
    final items = controller.items;

    return Scaffold(
      appBar: AppBar(title: const Text('Lista de Compras')),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            TextField(
              controller: controller.textController,
              decoration: const InputDecoration(labelText: 'Novo item'),
            ),
            ElevatedButton(
              onPressed: _addItem,
              child: const Text('Adicionar'),
            ),
            const SizedBox(height: 16),
            Expanded(
              child: ListView.builder(
                itemCount: items.length,
                itemBuilder: (context, index) {
                  final item = items[index];
                  return ListTile(
                    title: Text(item.name),
                    trailing: IconButton(
                      icon: const Icon(Icons.delete),
                      onPressed: () => _removeItem(index),
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
