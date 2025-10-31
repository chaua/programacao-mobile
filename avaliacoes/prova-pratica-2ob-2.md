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
    visible: false
  metadata:
    visible: false
---

# 📑 Prova prática 2ºB - 2

## 🎯 Objetivo

Implementar um **menu de configurações na AppBar** que permita alternar **tema** e **idioma** em tempo real e **salvar** a escolha localmente.

## 📁 Estrutura de pastas&#x20;

Dentro de `lib/`, use:

```
lib/
├── app/
│   └── app_widget.dart              # MaterialApp com tema/locale reativos
├── core/
│   ├── controllers/
│   │   ├── theme_controller.dart
│   │   └── locale_controller.dart
│   ├── services/
│   │   └── prefs_service.dart       # wrapper de SharedPreferences
│   └── theme/
│       └── app_theme.dart           # claro/escuro centralizados
├── l10n/
│   ├── app_en.arb
│   └── app_pt.arb
└── modules/
    ├── feed/
    │   └── feed_page.dart           # tela com AppBar e menu de Settings
    └── settings/
        └── settings_sheet.dart      # bottom sheets (tema/idioma)
```

## 1️⃣ Dependências e l10n

#### 1.1. `pubspec.yaml`

```yaml
dependencies:
  flutter:
    sdk: flutter
  shared_preferences: ^2.2.3

flutter:
  generate: true        # habilita gen-l10n
```

#### 1.2. Arquivos de tradução

Crie `lib/l10n/app_pt.arb`:

```json
{
  "@@locale": "pt",
  "appTitle": "Mini Instagram",
  "menuSettings": "Configurações",
  "menuTheme": "Tema",
  "menuLanguage": "Idioma",
  "themeLight": "Claro",
  "themeDark": "Escuro",
  "languagePortuguese": "Português (Brasil)",
  "languageEnglish": "Inglês (EUA)"
}
```

Crie `lib/l10n/app_en.arb`:

```json
{
  "@@locale": "en",
  "appTitle": "Mini Instagram",
  "menuSettings": "Settings",
  "menuTheme": "Theme",
  "menuLanguage": "Language",
  "themeLight": "Light",
  "themeDark": "Dark",
  "languagePortuguese": "Portuguese (Brazil)",
  "languageEnglish": "English (US)"
}
```

> **Por que**: usar gen-l10n evita libs extras; `AppLocalizations` é gerada automaticamente e integrada ao `MaterialApp`.

## 2️⃣ Tema centralizado

Crie `lib/core/theme/app_theme.dart`:

```dart
import 'package:flutter/material.dart';

class AppTheme {
  static ThemeData light = ThemeData(
    useMaterial3: true,
    colorScheme: ColorScheme.fromSeed(seedColor: Colors.teal),
    brightness: Brightness.light,
  );

  static ThemeData dark = ThemeData(
    useMaterial3: true,
    colorScheme: ColorScheme.fromSeed(seedColor: Colors.teal, brightness: Brightness.dark),
    brightness: Brightness.dark,
  );
}
```

> **Por que**: concentrar estilos facilita manutenção e troca dinâmica.

## 3️⃣ Persistência (SharedPreferences)

Crie `lib/core/services/prefs_service.dart`:

```dart
import 'package:shared_preferences/shared_preferences.dart';

class PrefsService {
  static const _kThemeKey = 'themeMode';   // 'light' | 'dark'
  static const _kLocaleKey = 'locale';     // 'pt' | 'en'

  Future<void> saveTheme(String value) async {
    final p = await SharedPreferences.getInstance();
    await p.setString(_kThemeKey, value);
  }

  Future<String?> loadTheme() async {
    final p = await SharedPreferences.getInstance();
    return p.getString(_kThemeKey);
  }

  Future<void> saveLocale(String value) async {
    final p = await SharedPreferences.getInstance();
    await p.setString(_kLocaleKey, value);
  }

  Future<String?> loadLocale() async {
    final p = await SharedPreferences.getInstance();
    return p.getString(_kLocaleKey);
  }
}
```

> **Por que**: um “service” isolado facilita testar e trocar implementação depois.

## 4️⃣ Controllers reativos (tema e idioma)

`lib/core/controllers/theme_controller.dart`:

```dart
import 'package:flutter/material.dart';
import '../services/prefs_service.dart';

class ThemeController extends ChangeNotifier {
  final PrefsService _prefs;
  ThemeMode _mode = ThemeMode.light;

  ThemeController(this._prefs);

  ThemeMode get mode => _mode;

  Future<void> load() async {
    final saved = await _prefs.loadTheme();
    _mode = (saved == 'dark') ? ThemeMode.dark : ThemeMode.light;
    notifyListeners();
  }

  Future<void> setLight() async {
    _mode = ThemeMode.light;
    await _prefs.saveTheme('light');
    notifyListeners();
  }

  Future<void> setDark() async {
    _mode = ThemeMode.dark;
    await _prefs.saveTheme('dark');
    notifyListeners();
  }
}
```

`lib/core/controllers/locale_controller.dart`:

```dart
import 'package:flutter/material.dart';
import '../services/prefs_service.dart';

class LocaleController extends ChangeNotifier {
  final PrefsService _prefs;
  Locale _locale = const Locale('pt');

  LocaleController(this._prefs);

  Locale get locale => _locale;

  Future<void> load() async {
    final saved = await _prefs.loadLocale();
    _locale = (saved == 'en') ? const Locale('en') : const Locale('pt');
    notifyListeners();
  }

  Future<void> setPortuguese() async {
    _locale = const Locale('pt');
    await _prefs.saveLocale('pt');
    notifyListeners();
  }

  Future<void> setEnglish() async {
    _locale = const Locale('en');
    await _prefs.saveLocale('en');
    notifyListeners();
  }
}
```

> **Por que**: `ChangeNotifier` é leve, perfeito para esse caso. No futuro, dá pra trocar por Riverpod/Bloc sem mexer na UI.

## 5️⃣ AppWidget com gen-l10n e Providers

Crie `lib/app/app_widget.dart`:

```dart
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:provider/provider.dart';
import '../core/controllers/locale_controller.dart';
import '../core/controllers/theme_controller.dart';
import '../core/services/prefs_service.dart';
import '../core/theme/app_theme.dart';
import '../modules/feed/feed_page.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';

class AppWidget extends StatelessWidget {
  const AppWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => ThemeController(PrefsService())..load()),
        ChangeNotifierProvider(create: (_) => LocaleController(PrefsService())..load()),
      ],
      child: Consumer2<ThemeController, LocaleController>(
        builder: (_, theme, locale, __) {
          return MaterialApp(
            debugShowCheckedModeBanner: false,
            title: 'Mini Instagram',
            theme: AppTheme.light,
            darkTheme: AppTheme.dark,
            themeMode: theme.mode,
            locale: locale.locale,
            supportedLocales: const [Locale('pt'), Locale('en')],
            localizationsDelegates: const [
              AppLocalizations.delegate,
              GlobalMaterialLocalizations.delegate,
              GlobalWidgetsLocalizations.delegate,
              GlobalCupertinoLocalizations.delegate,
            ],
            home: const FeedPage(),
          );
        },
      ),
    );
  }
}
```

> **Por que**: `MaterialApp` recebe `locale`, `supportedLocales` e `localizationsDelegates` do gen-l10n; providers reconstroem a UI quando algo muda.

## 6️⃣ AppBar com menu de Settings

Crie `lib/modules/feed/feed_page.dart`:

```dart
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import '../../core/controllers/locale_controller.dart';
import '../../core/controllers/theme_controller.dart';
import '../settings/settings_sheet.dart';

class FeedPage extends StatelessWidget {
  const FeedPage({super.key});

  @override
  Widget build(BuildContext context) {
    final i18n = AppLocalizations.of(context)!;

    return Scaffold(
      appBar: AppBar(
        title: Text(i18n.appTitle),
        actions: [
          PopupMenuButton<String>(
            tooltip: i18n.menuSettings,
            onSelected: (value) async {
              switch (value) {
                case 'theme':
                  await showModalBottomSheet(
                    context: context,
                    builder: (_) => const ThemeSheet(),
                  );
                  break;
                case 'lang':
                  await showModalBottomSheet(
                    context: context,
                    builder: (_) => const LanguageSheet(),
                  );
                  break;
              }
            },
            itemBuilder: (context) => [
              PopupMenuItem(value: 'theme', child: Text(i18n.menuTheme)),
              PopupMenuItem(value: 'lang', child: Text(i18n.menuLanguage)),
            ],
          ),
        ],
      ),
      body: const Center(
        child: Text('Feed... (conteúdo estático para o trabalho)'),
      ),
    );
  }
}
```

> **Por que**: `PopupMenuButton` mantém a UI padrão de “3 pontinhos”; os itens abrem **bottom sheets** reutilizáveis.

## 7️⃣ Bottom sheets de Tema e Idioma

Crie `lib/modules/settings/settings_sheet.dart`:

```dart
import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:provider/provider.dart';
import '../../core/controllers/theme_controller.dart';
import '../../core/controllers/locale_controller.dart';

class ThemeSheet extends StatelessWidget {
  const ThemeSheet({super.key});

  @override
  Widget build(BuildContext context) {
    final i = AppLocalizations.of(context)!;
    final theme = context.watch<ThemeController>();

    return SafeArea(
      child: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            ListTile(title: Text(i.menuTheme, style: Theme.of(context).textTheme.titleLarge)),
            RadioListTile<ThemeMode>(
              title: Text(i.themeLight),
              value: ThemeMode.light,
              groupValue: theme.mode,
              onChanged: (_) => theme.setLight().then((_) => Navigator.pop(context)),
            ),
            RadioListTile<ThemeMode>(
              title: Text(i.themeDark),
              value: ThemeMode.dark,
              groupValue: theme.mode,
              onChanged: (_) => theme.setDark().then((_) => Navigator.pop(context)),
            ),
          ],
        ),
      ),
    );
  }
}

class LanguageSheet extends StatelessWidget {
  const LanguageSheet({super.key});

  @override
  Widget build(BuildContext context) {
    final i = AppLocalizations.of(context)!;
    final loc = context.watch<LocaleController>();

    return SafeArea(
      child: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            ListTile(title: Text(i.menuLanguage, style: Theme.of(context).textTheme.titleLarge)),
            RadioListTile<Locale>(
              title: Text(i.languagePortuguese),
              value: const Locale('pt'),
              groupValue: loc.locale,
              onChanged: (_) => loc.setPortuguese().then((_) => Navigator.pop(context)),
            ),
            RadioListTile<Locale>(
              title: Text(i.languageEnglish),
              value: const Locale('en'),
              groupValue: loc.locale,
              onChanged: (_) => loc.setEnglish().then((_) => Navigator.pop(context)),
            ),
          ],
        ),
      ),
    );
  }
}
```

> **Por que**: bottom sheets são intuitivos para escolhas rápidas e mantêm o usuário no contexto da tela atual.

## 8️⃣  `main.dart`

Se o seu `.zip` já tem, apenas garanta que chama o `AppWidget`:

```dart
import 'package:flutter/material.dart';
import 'app/app_widget.dart';

void main() {
  runApp(const AppWidget());
}
```

## 9️⃣ Teste manual (checklist)

* [ ] App inicia em **Português** e **tema claro** (se não houver preferências salvas).
* [ ] Abrir menu (⋮) → **Tema** → alternar entre claro/escuro (aplica na hora).
* [ ] Abrir menu (⋮) → **Idioma** → alternar PT/EN (textos mudam na hora).
* [ ] Fechar e reabrir o app: **mantém** as escolhas (persistência ok).
* [ ] Textos aparecem traduzidos conforme `.arb`.

## 🛠️ Dicas rápidas

* Rodar geração de l10n: basta dar `flutter run` (o `generate: true` cuida), mas se precisar, `flutter gen-l10n`.
* Para expandir: adicione **sistema** (seguir tema do sistema) e `ThemeMode.system`.
