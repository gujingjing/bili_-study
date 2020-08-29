import 'package:fluro/fluro.dart';
import 'package:flutter/material.dart';
import 'package:myflutter/page/DefaultPage.dart';
import 'package:myflutter/page/HomePage.dart';
import 'package:myflutter/page/PageDemo.dart';


//homePage
Handler homePage = Handler(
    handlerFunc: (BuildContext context, Map<String, List<String>> params) {
      return createWidget(HomePage());
    });

//not found page
Handler noFoundPage = Handler(
    handlerFunc: (BuildContext context, Map<String, List<String>> params) {
      print("ERROR===Route was not found");
      return createWidget(DefaultPage());
    });

//demo1
Handler demo1Page = Handler(
    handlerFunc: (BuildContext context, Map<String, List<String>> params) {
      return createWidget(PageDemo());
    });

Widget createWidget(Widget widget) {
  return widget;
}