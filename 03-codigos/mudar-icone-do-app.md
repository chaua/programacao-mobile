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

# Mudar ícone do App

## 1️⃣ Adicionar a dependência

No arquivo `pubspec.yaml`, adicione:

```yaml
dev_dependencies:
  flutter_launcher_icons: ^0.13.1

flutter_launcher_icons:
  android: "launcher_icon"
  ios: true
  image_path: "assets/icon/app_icon.png"
```

> 💡 A imagem (`app_icon.png`) deve estar dentro da pasta `assets/icon/`. Recomenda-se um ícone **quadrado (1024x1024 px)** em **PNG sem fundo**.

## 2️⃣ Rodar o comando

Execute no terminal:

```bash
flutter pub get
flutter pub run flutter_launcher_icons
```

Isso vai gerar automaticamente todos os tamanhos necessários e atualizar:

* `android/app/src/main/res/mipmap-*`
* `ios/Runner/Assets.xcassets/AppIcon.appiconset/`

## 3️⃣ Limpar cache e rodar o app

Depois, limpe e rode novamente o app:

```bash
flutter clean
flutter run
```

## 4️⃣ Configurações adicionais (Opcional)&#x20;

Você pode personalizar para plataformas específicas:

```yaml
flutter_launcher_icons:
  image_path: "assets/icon/app_icon.png"
  android: true
  ios: true
  web:
    generate: true
    image_path: "assets/icon/app_icon.png"
    background_color: "#ffffff"
    theme_color: "#000000"
```

## ✅ Dicas finais

* Use o site [https://appicon.co](https://appicon.co) se quiser gerar ícones manualmente.
* Sempre use imagens sem texto ou muito detalhadas — ícones devem ser simples e legíveis.
* No Android, o ícone adaptativo usa camadas (foreground/background). Você pode definir isso também.
