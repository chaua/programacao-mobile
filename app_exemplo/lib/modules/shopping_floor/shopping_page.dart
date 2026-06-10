import 'package:flutter/material.dart';
import 'shopping_controller.dart';
import 'shopping_model.dart';

class ShoppingFloorPage extends StatefulWidget {
  final ShoppingController? controller;

  const ShoppingFloorPage({super.key, required this.controller});

  @override
  State<ShoppingFloorPage> createState() => _ShoppingFloorPageState();
}

class _ShoppingFloorPageState extends State<ShoppingFloorPage> {
  @override
  void initState() {
    super.initState();
    widget.controller?.loadItems(() {
      setState(() {});
    });
  }

  @override
  void dispose() {
    // Não chamar dispose no controller compartilhado
    super.dispose();
  }

  void _addItem() {
    widget.controller?.addItem(() => setState(() {}));
  }

  void _deleteItem(ShoppingItem? item) {
    if (item != null) {
      widget.controller?.deleteItem(item, () => setState(() {}));
    }
  }

  @override
  Widget build(BuildContext context) {
    final items = widget.controller?.items;

    return Scaffold(
      appBar: AppBar(title: const Text('Lista de Compras (Floor)')),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            TextField(
              controller: widget.controller?.textController,
              decoration: const InputDecoration(labelText: 'Novo item'),
            ),
            ElevatedButton(onPressed: _addItem, child: const Text('Adicionar')),
            const SizedBox(height: 16),
            Expanded(
              child: ListView.builder(
                itemCount: items?.length,
                itemBuilder: (context, index) {
                  final item = items?[index];
                  return ListTile(
                    title: Text(item?.name ?? ''),
                    trailing: IconButton(
                      icon: const Icon(Icons.delete),
                      onPressed: () => _deleteItem(item),
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
