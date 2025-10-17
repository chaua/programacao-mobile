---
layout:
  width: default
  title:
    visible: true
  description:
    visible: false
  tableOfContents:
    visible: true
  outline:
    visible: false
  pagination:
    visible: true
  metadata:
    visible: false
---

# 🅰️ Home

### 🎯 Objetivo

Exibir uma lista paginada de **produtos** do DummyJSON, com:

* carregamento inicial,
* **pull-to-refresh**,
* **scroll infinito** (limit/skip),
* estados de **loading**, **erro** e **lista vazia**,
* tudo com **setState()**.

{% hint style="warning" %}
Aqui usaremos o recurso de produtos. Adapte para o recurso escolhido.
{% endhint %}

### 📁 Estrutura

```
lib/
├── shared/services/api_client.dart
└── modules/
    └── produtos/
        ├── produtos_repository.dart
        └── produtos_page.dart
```

> Obs.: depois você poderá duplicar esse padrão para outros recursos (users, posts, etc.).

### 🔌 `modules/produtos/produtos_repository.dart`

Pequeno repositório que chama o `ApiClient` e retorna apenas os campos que vamos usar na lista.

```dart
// lib/modules/produtos/produtos_repository.dart
import 'package:your_app/shared/services/api_client.dart';

class ProdutoItem {
  final int id;
  final String title;
  final String? thumbnail;
  final num price;

  ProdutoItem({
    required this.id,
    required this.title,
    required this.price,
    this.thumbnail,
  });

  factory ProdutoItem.fromMap(Map<String, dynamic> map) {
    return ProdutoItem(
      id: map['id'] as int,
      title: map['title'] as String,
      price: map['price'] as num,
      thumbnail: map['thumbnail'] as String?,
    );
  }
}

class ProdutosPageResult {
  final List<ProdutoItem> items;
  final int total;
  final int skip;
  final int limit;

  ProdutosPageResult({
    required this.items,
    required this.total,
    required this.skip,
    required this.limit,
  });
}

class ProdutosRepository {
  final ApiClient _api;

  ProdutosRepository({ApiClient? api}) : _api = api ?? ApiClient();

  /// GET https://dummyjson.com/products?limit=...&skip=...&q=...
  Future<ProdutosPageResult> listar({int limit = 10, int skip = 0, String? q}) async {
    final query = <String, String>{
      'limit': '$limit',
      'skip': '$skip',
      if (q != null && q.isNotEmpty) 'q': q,
    };

    final json = await _api.getJson('/products', query: query);
    final list = (json['products'] as List).cast<Map<String, dynamic>>();
    final items = list.map(ProdutoItem.fromMap).toList();

    return ProdutosPageResult(
      items: items,
      total: json['total'] as int? ?? items.length,
      skip: json['skip'] as int? ?? skip,
      limit: json['limit'] as int? ?? limit,
    );
  }
}
```

### 🖼️ `modules/produtos/produtos_page.dart`

Página com `ListView.builder`, **RefreshIndicator** e **infinite scroll**. Tudo com `setState()`.

```dart
// lib/modules/produtos/produtos_page.dart
import 'package:flutter/material.dart';
import 'produtos_repository.dart';

class ProdutosPage extends StatefulWidget {
  const ProdutosPage({super.key});

  @override
  State<ProdutosPage> createState() => _ProdutosPageState();
}

class _ProdutosPageState extends State<ProdutosPage> {
  final _repo = ProdutosRepository();

  final _items = <ProdutoItem>[];
  bool _loadingInitial = true;   // loading da primeira página
  bool _loadingMore = false;     // loading de paginação
  bool _refreshing = false;      // pull-to-refresh
  String? _error;

  // paginação
  static const int _pageSize = 12;
  int _skip = 0;
  int _total = 0;

  final _scrollCtrl = ScrollController();

  @override
  void initState() {
    super.initState();
    _fetchInitial();
    _scrollCtrl.addListener(_onScroll);
  }

  @override
  void dispose() {
    _scrollCtrl.dispose();
    super.dispose();
  }

  Future<void> _fetchInitial() async {
    setState(() {
      _loadingInitial = true;
      _error = null;
      _items.clear();
      _skip = 0;
      _total = 0;
    });

    try {
      final page = await _repo.listar(limit = _pageSize, skip = 0);
      setState(() {
        _items.addAll(page.items);
        _total = page.total;
        _skip = page.skip + page.items.length;
      });
    } catch (e) {
      setState(() => _error = e.toString());
    } finally {
      if (mounted) setState(() => _loadingInitial = false);
    }
  }

  Future<void> _loadMore() async {
    if (_loadingMore || _items.length >= _total) return;
    setState(() => _loadingMore = true);

    try {
      final page = await _repo.listar(limit = _pageSize, skip = _skip);
      setState(() {
        _items.addAll(page.items);
        _skip += page.items.length;
      });
    } catch (e) {
      // mostra um SnackBar mas não quebra a tela
      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Falha ao carregar mais: $e')),
        );
      }
    } finally {
      if (mounted) setState(() => _loadingMore = false);
    }
  }

  void _onScroll() {
    if (_scrollCtrl.position.pixels >=
        _scrollCtrl.position.maxScrollExtent * 0.95) {
      _loadMore();
    }
  }

  Future<void> _onRefresh() async {
    setState(() => _refreshing = true);
    await _fetchInitial();
    if (mounted) setState(() => _refreshing = false);
  }

  @override
  Widget build(BuildContext context) {
    if (_loadingInitial) {
      return const Scaffold(
        appBar: AppBar(title: Text('Produtos')),
        body: Center(child: CircularProgressIndicator()),
      );
    }

    if (_error != null) {
      return Scaffold(
        appBar: AppBar(title: const Text('Produtos')),
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(16),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Text(_error!, textAlign: TextAlign.center, style: const TextStyle(color: Colors.red)),
                const SizedBox(height: 12),
                ElevatedButton(
                  onPressed: _fetchInitial,
                  child: const Text('Tentar novamente'),
                ),
              ],
            ),
          ),
        ),
      );
    }

    if (_items.isEmpty) {
      return Scaffold(
        appBar: AppBar(title: const Text('Produtos')),
        body: Center(
          child: TextButton(
            onPressed: _fetchInitial,
            child: const Text('Sem resultados. Tocar para recarregar'),
          ),
        ),
      );
    }

    return Scaffold(
      appBar: AppBar(title: const Text('Produtos')),
      body: RefreshIndicator(
        onRefresh: _onRefresh,
        child: ListView.builder(
          controller: _scrollCtrl,
          physics: const AlwaysScrollableScrollPhysics(),
          itemCount: _items.length + 1, // +1 para o rodapé (loader)
          itemBuilder: (context, index) {
            if (index == _items.length) {
              // rodapé de paginação
              if (_items.length >= _total) {
                return const Padding(
                  padding: EdgeInsets.all(16),
                  child: Center(child: Text('• fim da lista •')),
                );
              }
              return Padding(
                padding: const EdgeInsets.all(16),
                child: Center(
                  child: _loadingMore
                      ? const CircularProgressIndicator(strokeWidth: 2)
                      : const SizedBox.shrink(),
                ),
              );
            }

            final p = _items[index];
            return ListTile(
              leading: p.thumbnail != null
                  ? ClipRRect(
                      borderRadius: BorderRadius.circular(6),
                      child: Image.network(p.thumbnail!, width: 56, height: 56, fit: BoxFit.cover),
                    )
                  : const CircleAvatar(child: Icon(Icons.image_not_supported)),
              title: Text(p.title, maxLines: 1, overflow: TextOverflow.ellipsis),
              subtitle: Text('R\$ ${p.price}'),
              onTap: () {
                // detalhes virão depois
                // Navigator.pushNamed(context, AppRoutes.produtoDetalhe, arguments: p.id);
              },
            );
          },
        ),
      ),
    );
  }
}
```

> ⚠️ Note a sintaxe: usei `listar(limit = _pageSize, skip = _skip)` para deixar evidente os parâmetros — se preferir, troque por nomeados padrão `listar(limit: _pageSize, skip: _skip)` (recomendo).

### 🔗 Ligando a Home à rota `/`

No seu `AppRoutes.getRoutes()`, a rota **home** deve apontar para a `ProdutosPage`.

```dart
// lib/app/app_routes.dart (trecho)
import '../modules/produtos/produtos_page.dart';

class AppRoutes {
  static const String home = '/';
  static const String splash = '/splash';
  static const String login = '/login';

  static Future<Map<String, WidgetBuilder>> getRoutes() async {
    // ... authService/authRepository como antes
    return {
      splash: (_) => SplashPage(authRepository: authRepository),
      login:  (_) => LoginPage(authService: authService, authRepository: authRepository),
      home:   (_) => const ProdutosPage(), // ← Home agora é a lista de produtos
    };
  }
}
```

### 💡 Dicas

* **Reuso fácil:** o padrão `Repository + Page` permite trocar `/products` por qualquer outro recurso trocando só o repo e o item.
* **UX:** se a API estiver lenta, o **pull-to-refresh** dá mais controle ao aluno.
* **Paginação segura:** bloqueie `_loadMore` quando `_loadingMore` já estiver ativo ou quando `_items.length >= _total`.
* **Imagens:** `Image.network` já é suficiente; em produção considere cache e placeholders.
* **Erro não bloqueante:** falhas de “carregar mais” viram `SnackBar`, mas a lista atual continua visível.
