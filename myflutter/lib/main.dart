import 'dart:io';
import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:myflutter/channel/channel_const.dart';
import 'package:myflutter/router/Routers.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  _initialize();
  runApp(MainApp());
}

void _initialize(){
  if(Platform.isAndroid){
    //设置沉浸式
    SystemUiOverlayStyle systemUiOverlayStyle = SystemUiOverlayStyle(statusBarColor: Colors.transparent);
    SystemChrome.setSystemUIOverlayStyle(systemUiOverlayStyle);
  }
  Routers.init();
  //channel 初始化
  for (var channel in CHANNEL_LIST) {
    channel.init();
  }
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
        home: Routers.parseUriPage(context,window.defaultRouteName)
    );
  }
}