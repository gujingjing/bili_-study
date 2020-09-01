import 'package:fluro/fluro.dart';
import 'package:flutter/material.dart';
import 'package:myflutter/router/router_handler.dart';

class Routers {
  static Router router;

  Routers._();

  static init() {
    if (router == null) {
      router = Router();
      configureRoutes(router);
    }
  }

  //路由path
  static String root = "/";
  static const String Demo1 = "/demo1";

  //定义页面路由
  static void configureRoutes(Router router) {
    //首页
    router.define(root, handler: homePage);
    //demo1
    router.define(Demo1, handler: demo1Page);
    //未找到的页面
    router.notFoundHandler = noFoundPage;
  }

  static Widget parseUriPage(BuildContext context, String routeUri, {Widget defaultPage}) {
    //非正式环境进入测试界面
    if (!bool.fromEnvironment("dart.vm.product")) {
      // defaultPage = QtTestPage();
    }
    var uri = Uri.parse(routeUri);
    var handler = router.match(uri.path)?.route?.handler ?? null;
    if (handler != null && handler is Handler) {
      return handler.handlerFunc(
          context, uri.queryParametersAll ?? new Map<String, List<String>>());
    } else {
      return defaultPage;
    }
  }

  ///路由跳转
  ///可使用then链式调用获取页面关闭结果 ,例: Navigator.of(context).pop('xxx')
  static Future navigateTo(BuildContext context, String path,
      {Map<String, dynamic> params,
      TransitionType transition = TransitionType.native}) {
    Uri uri = Uri(path: path, queryParameters: params);
    return router.navigateTo(context, uri.toString(), transition: transition);
  }
}
