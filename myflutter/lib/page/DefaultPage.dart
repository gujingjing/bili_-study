import 'package:flutter/material.dart';

class DefaultPage extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("DefaultPage"),
      ),
      body: Center(
        child: Text("DefaultPage 测试页面")
      ),
    );
  }

}