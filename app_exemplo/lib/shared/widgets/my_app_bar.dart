import 'package:flutter/material.dart';

class MyAppBar extends AppBar {
  MyAppBar({required BuildContext context, super.key})
    : super(
        elevation: 2.0,
        shadowColor: Theme.of(context).colorScheme.shadow,
        title: const Text(
          "App Template",
          style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
        ),
        centerTitle: true,
      );
}
