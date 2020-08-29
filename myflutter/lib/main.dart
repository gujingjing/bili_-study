import 'dart:ui' as ui;
import 'dart:ui';
import 'package:fluro/fluro.dart';
import 'package:flutter/material.dart';
import 'package:myflutter/main_fluro.dart';
import 'package:myflutter/main_flutter_boost.dart';
import 'package:myflutter/page/DefaultPage.dart';
import 'package:myflutter/page/HomePage.dart';
import 'package:myflutter/page/PageDemo.dart';
import 'package:myflutter/router/Routers.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  initialize();
  runApp(FluroApp());
}

void initialize(){
  Routers.init();
}

class MainApp extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return _MainAppState();
  }
}

class _MainAppState extends State<MainApp>{

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Boost example',
        home: _widgetRoute(window.defaultRouteName)
    );
  }
}

Widget _widgetRoute(String defaultRouteName) {
  switch(defaultRouteName){
    case Routers.Demo1:
      return PageDemo();
    default:
      return HomePage();
  }
}