import 'dart:ui' as ui;
import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:myflutter/page/DefaultPage.dart';
import 'package:myflutter/page/PageDemo.dart';
import 'package:myflutter/router/Routers.dart';

class FlutterBoostApp extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return _FlutterBoostAppState();
  }
}

class _FlutterBoostAppState extends State<FlutterBoostApp>{

  @override
  void initState() {
    super.initState();

    FlutterBoost.singleton.registerPageBuilders({
      Routers.root: (pageName, params, _) {
        print("first flutterPage params:$params");
        return DefaultPage();
      },
      Routers.Demo1: (pageName, params, _) {
        print("second flutterPage params:$params");
        return PageDemo();
      },
    });

    // FlutterBoost.handleOnStartPage();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Boost example',
        builder: FlutterBoost.init(),
        home: Container());
  }
}