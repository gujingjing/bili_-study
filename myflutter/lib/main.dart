import 'dart:ui' as ui;
import 'package:fluro/fluro.dart';
import 'package:flutter/material.dart';
import 'package:myflutter/main_fluro.dart';
import 'package:myflutter/main_flutter_boost.dart';
import 'package:myflutter/page/DefaultPage.dart';
import 'package:myflutter/page/PageDemo.dart';
import 'package:myflutter/router/Routers.dart';

void main() {
  initialize();
  runApp(FluroApp());
}

void initialize(){
  Routers.init();
}
