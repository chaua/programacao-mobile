import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/adapters.dart';

import 'app/app_routes.dart';
import 'app/app_widget.dart';
import 'firebase_options.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Inicializa o firebase no projeto
  if (kIsWeb) {
    await Firebase.initializeApp(
      options: DefaultFirebaseOptions.currentPlatform,
    );
  } else {
    await Firebase.initializeApp();
  }

  // Inicializa o Hive
  await Hive.initFlutter(); // Initialize Hive for Flutter

  // Inicializa o mapa de rotas
  var rotas = await AppRoutes.getRoutes();

  // Inicializa o aplicativo Flutter
  runApp(AppWidget(rotas));
}