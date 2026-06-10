import 'package:app_exemplo/app/app_routes.dart';
import 'package:app_exemplo/shared/widgets/my_app_bar.dart';
import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: MyAppBar(context: context),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              Text(
                'Bem-vindo ao App Exemplos!!',
                style: Theme.of(context).textTheme.headlineMedium,
                textAlign: TextAlign.center,
              ),
              const SizedBox(height: 24),
              ElevatedButton(
                onPressed: () => Navigator.pushNamed(context, AppRoutes.contador),
                child: const Text('Contador'),
              ),
              ElevatedButton(
                onPressed: () => Navigator.pushNamed(context, AppRoutes.piada),
                child: const Text('Piada'),
              ),
              ElevatedButton(
                onPressed: () => Navigator.pushNamed(context, AppRoutes.semaforo),
                child: const Text('Semáforo'),
              ),
              ElevatedButton(
                onPressed: () => Navigator.pushNamed(context, AppRoutes.shoppingShared),
                child: const Text('Shopping Shared'),
              ),
              ElevatedButton(
                onPressed: () => Navigator.pushNamed(context, AppRoutes.shoppingHive),
                child: const Text('Shopping Hive'),
              ),
              ElevatedButton(
                onPressed: () => Navigator.pushNamed(context, AppRoutes.shoppingFloor),
                child: const Text('Shopping Floor'),
              ),
              ElevatedButton(
                onPressed: () => Navigator.pushNamed(context, AppRoutes.shoppingFirebase),
                child: const Text('Shopping Firebase'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
