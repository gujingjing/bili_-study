import 'dart:async';

import 'package:flutter/services.dart';
import 'package:gflutter_interface/gflutter_interface.dart';

class ToastPlugin implements GToast {
  static const MethodChannel _channel = const MethodChannel('toast_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  @override
  Future toast(String msg) {
    return _channel.invokeMethod('toast', {"msg": msg});
  }

  @override
  Future toastLong(String msg) {
    return _channel.invokeMethod('toast', {"msg": msg, "type": 1});
  }
}
