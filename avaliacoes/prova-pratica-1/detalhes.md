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

# 🅱️ Detalhes

### 🎯 Objetivo

Exibir os **detalhes de um produto** selecionado (imagem grande, título, preço, categoria, marca, avaliação e descrição), com:

* carregamento inicial,
* tratamento de erro + retry,
* layout simples e legível,
* navegação via **id** passado pela lista.

### 📁 Estrutura

```
lib/
└── modules/
    └── produtos/
        ├── produtos_repository.dart        # adicionar método detalhe()
        └── produto_detalhe_page.dart       # NOVO
```

### 🧩 Repository – adicionar modelo + método `detalhe(id)`

Abra `lib/modules/produtos/produtos_repository.dart` e **adicione** o modelo de detalhe e o método.

```dart
// lib/modules/produtos/produtos_repository.dart
import 'package:your_app/shared/services/api_client.dart';

// ... (ProdutoItem, ProdutosPageResult e ProdutosRepository.listar já existem)

class ProdutoDetalhe {
  final int id;
  final String title;
  final String description;
  final num price;
  final String? brand;
  final String? category;
  final num? rating;
  final String? thumbnail;      // imagem “principal”
  final List<String> images;    // galeria

  ProdutoDetalhe({
    required this.id,
    required this.title,
    required this.description,
    required this.price,
    this.brand,
    this.category,
    this.rating,
    this.thumbnail,
    this.images = const [],
  });

  factory ProdutoDetalhe.fromMap(Map<String, dynamic> map) {
    return ProdutoDetalhe(
      id: map['id'] as int,
      title: map['title'] as String,
      description: map['description'] as String? ?? '',
      price: map['price'] as num,
      brand: map['brand'] as String?,
      category: map['category'] as String?,
      rating: (map['rating'] is num) ? map['rating'] as num : null,
      thumbnail: map['thumbnail'] as String?,
      images: (map['images'] is List)
          ? (map['images'] as List).whereType<String>().toList()
          : const [],
    );
  }
}

class ProdutosRepository {
  final ApiClient _api;

  ProdutosRepository({ApiClient? api}) : _api = api ?? ApiClient();

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

  /// GET https://dummyjson.com/products/{id}
  Future<ProdutoDetalhe> detalhe(int id) async {
    final json = await _api.getJson('/products/$id');
    return ProdutoDetalhe.fromMap(json);
  }
}
```

### 🖼️ Página – `produto_detalhe_page.dart`

```dart
// lib/modules/produtos/produto_detalhe_page.dart
import 'package:flutter/material.dart';
import 'produtos_repository.dart';

class ProdutoDetalhePage extends StatefulWidget {
  final int id;
  const ProdutoDetalhePage({super.key, required this.id});

  @override
  State<ProdutoDetalhePage> createState() => _ProdutoDetalhePageState();
}

class _ProdutoDetalhePageState extends State<ProdutoDetalhePage> {
  final _repo = ProdutosRepository();

  ProdutoDetalhe? _data;
  bool _loading = true;
  String? _error;

  @override
  void initState() {
    super.initState();
    _fetch();
  }

  Future<void> _fetch() async {
    setState(() {
      _loading = true;
      _error = null;
    });
    try {
      final d = await _repo.detalhe(widget.id);
      setState(() => _data = d);
    } catch (e) {
      setState(() => _error = e.toString());
    } finally {
      if (mounted) setState(() => _loading = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return Scaffold(
      appBar: AppBar(title: const Text('Detalhes do Produto')),
      body: _loading
          ? const Center(child: CircularProgressIndicator())
          : _error != null
              ? _ErrorView(message: _error!, onRetry: _fetch)
              : _data == null
                  ? const Center(child: Text('Produto não encontrado'))
                  : SingleChildScrollView(
                      padding: const EdgeInsets.all(16),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          _HeroImage(urls: _data!.images.isNotEmpty
                              ? _data!.images
                              : (_data!.thumbnail != null ? [_data!.thumbnail!] : [])),
                          const SizedBox(height: 16),
                          Text(
                            _data!.title,
                            style: theme.textTheme.headlineSmall?.copyWith(fontWeight: FontWeight.w600),
                          ),
                          const SizedBox(height: 8),
                          Wrap(
                            spacing: 12,
                            runSpacing: 8,
                            children: [
                              _ChipInfo(icon: Icons.sell_outlined, label: 'R\$ ${_data!.price}'),
                              if (_data!.brand != null)
                                _ChipInfo(icon: Icons.factory_outlined, label: _data!.brand!),
                              if (_data!.category != null)
                                _ChipInfo(icon: Icons.category_outlined, label: _data!.category!),
                              if (_data!.rating != null)
                                _ChipInfo(icon: Icons.star_rate_rounded, label: '${_data!.rating}'),
                            ],
                          ),
                          const SizedBox(height: 16),
                          Text('Descrição', style: theme.textTheme.titleMedium),
                          const SizedBox(height: 6),
                          Text(
                            _data!.description.isEmpty ? 'Sem descrição.' : _data!.description,
                            style: theme.textTheme.bodyMedium,
                          ),
                        ],
                      ),
                    ),
    );
  }
}

class _ErrorView extends StatelessWidget {
  final String message;
  final VoidCallback onRetry;
  const _ErrorView({required this.message, required this.onRetry});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text(message, textAlign: TextAlign.center, style: const TextStyle(color: Colors.red)),
            const SizedBox(height: 12),
            ElevatedButton(onPressed: onRetry, child: const Text('Tentar novamente')),
          ],
        ),
      ),
    );
  }
}

class _HeroImage extends StatefulWidget {
  final List<String> urls;
  const _HeroImage({required this.urls});

  @override
  State<_HeroImage> createState() => _HeroImageState();
}

class _HeroImageState extends State<_HeroImage> {
  int _index = 0;

  @override
  Widget build(BuildContext context) {
    if (widget.urls.isEmpty) {
      return AspectRatio(
        aspectRatio: 16 / 9,
        child: Container(
          color: Colors.black12,
          child: const Center(child: Icon(Icons.image_not_supported, size: 48)),
        ),
      );
    }

    final url = widget.urls[_index.clamp(0, widget.urls.length - 1)];
    return Column(
      children: [
        AspectRatio(
          aspectRatio: 16 / 9,
          child: ClipRRect(
            borderRadius: BorderRadius.circular(12),
            child: Image.network(url, fit: BoxFit.cover),
          ),
        ),
        if (widget.urls.length > 1) ...[
          const SizedBox(height: 8),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              IconButton(
                tooltip: 'Anterior',
                onPressed: _index > 0 ? () => setState(() => _index--) : null,
                icon: const Icon(Icons.chevron_left),
              ),
              Text('${_index + 1}/${widget.urls.length}'),
              IconButton(
                tooltip: 'Próxima',
                onPressed: _index < widget.urls.length - 1 ? () => setState(() => _index++) : null,
                icon: const Icon(Icons.chevron_right),
              ),
            ],
          ),
        ],
      ],
    );
  }
}

class _ChipInfo extends StatelessWidget {
  final IconData icon;
  final String label;
  const _ChipInfo({required this.icon, required this.label});

  @override
  Widget build(BuildContext context) {
    return Chip(
      avatar: Icon(icon, size: 18),
      label: Text(label),
    );
  }
}
```

### 🧭 Rotas – adicionar a rota de detalhes

Atualize seu `app_routes.dart` para incluir a rota de detalhes **com leitura do argumento `id`**.

```dart
// lib/app/app_routes.dart (trecho)
import '../modules/produtos/produto_detalhe_page.dart';

class AppRoutes {
  static const String home = '/';
  static const String splash = '/splash';
  static const String login = '/login';
  static const String produtoDetalhe = '/produto/detalhe';

  static Future<Map<String, WidgetBuilder>> getRoutes() async {
    final authService = AuthService();
    final authRepository = AuthRepository();

    return {
      splash: (_) => SplashPage(authRepository: authRepository),
      login:  (_) => LoginPage(authService: authService, authRepository: authRepository),
      home:   (_) => const ProdutosPage(),
      produtoDetalhe: (context) {
        final args = ModalRoute.of(context)!.settings.arguments as int;
        return ProdutoDetalhePage(id: args);
      },
    };
  }
}
```

***

### 🔗 Navegação a partir da lista

> No `ListTile` da sua `ProdutosPage`, ajuste o `onTap`:

```dart
onTap: () {
  Navigator.pushNamed(
    context,
    AppRoutes.produtoDetalhe,
    arguments: p.id,
  );
},
```

_(lembre de importar `app_routes.dart` na página da lista)_

### 💡 Dicas

* **Falha ao carregar?** A UI de erro traz botão **“Tentar novamente”** que chama `_fetch()`.
* **Layout responsivo:** a **hero image** usa `AspectRatio` 16:9 para não "pular" durante o carregamento.
* **Galeria simples:** se houver várias imagens, setinhas trocam a foto; com uma só, oculta a navegação.
* **Campos opcionais:** `brand/category/rating` só aparecem quando existem.
* **Separação de responsabilidades:** a página só consome o `ProdutosRepository`; nenhuma chamada HTTP direta na UI.
