import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class PageDemo extends StatelessWidget{

  static const MethodChannel _channel = MethodChannel("gjj.flutter.util");

  void toast(){
    print("PageDemo-toast");
    _channel.invokeMethod("toast",{"msg": "msg", "type": ""});
  }


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
        child: RaisedButton(
          child: Text("点击toast"),
          onPressed: toast,
        )
      ),
    );
  }

}