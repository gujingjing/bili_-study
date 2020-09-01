import 'package:flutter/material.dart';
import 'package:myflutter/channel/backpress/channel_backpress.dart';
import 'package:myflutter/channel/toast/channel_toast.dart';

class PageDemo extends StatelessWidget {
  void toast() {
    print("PageDemo-toast");
    GToast.instance().toast("测试toast");
  }

  void closePage() {
    print("PageDemo-closePage");
    GBack.instance().closePage();
  }

  void backPress(BuildContext buildContext) {
    print("PageDemo-backPress");
    GBack.instance().backPress(buildContext);
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
              backPress(context);
            },
          ),
        ),
        body: Column(
          children: [
            RaisedButton(
              child: Text("点击toast"),
              onPressed: toast,
            ),
            RaisedButton(
              child: Text("回退"),
              onPressed: (){
                backPress(context);
              },
            ),
            RaisedButton(
              child: Text("关闭当前页面"),
              onPressed: closePage,
            ),
          ],
        ));
  }
}
