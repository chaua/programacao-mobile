import 'package:flutter/material.dart';
import 'shopping_controller.dart';
import 'shopping_model.dart';

class ShoppingHivePage extends StatefulWidget {
  const ShoppingHivePage({super.key});

  @override
  State<ShoppingHivePage> createState() => _ShoppingPageState();
}

class _ShoppingPageState extends State<ShoppingHivePage> {
  final ShoppingController controller = ShoppingController();

  @override
  void initState() {
    super.initState();
    controller.init().then((_) {
      setState(() {}); // carrega os dados
    });
  }

  @override
  void dispose() {
    controller.dispose();
    super.dispose();
  }

  void _addItem() {
    controller.addItem(() => setState(() {}));
  }

  void _removeItem(int index) {
    controller.removeItem(index, () => setState(() {}));
  }

  @override
  Widget build(BuildContext context) {
    final items = controller.items;

    return Scaffold(
      appBar: AppBar(title: const Text('Lista de Compras (Hive)')),
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
