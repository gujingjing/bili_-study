import 'package:flutter/material.dart';

class PageDemo extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("PageDemo1"),
        leading: IconButton(
          icon: Icon(
            Icons.arrow_back,
            size: 20,
          ),
          onPressed: () {
            Navigator.pop(context); // 关闭当前页面
          },
        ),
      ),
      body: Center(
        child: Text("PageDemo 测试页面")
      ),
    );
  }

}