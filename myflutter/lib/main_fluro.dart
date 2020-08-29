import 'dart:ui' as ui;
import 'package:flutter/material.dart';
import 'package:myflutter/router/Routers.dart';

class FluroApp extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return _FluroAppAppState();
  }
}

class _FluroAppAppState extends State<FluroApp>{

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Boost example',
        onGenerateRoute: Routers.router.generator,
    );
  }
}