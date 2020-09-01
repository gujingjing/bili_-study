import 'package:flutter/services.dart';
import 'package:myflutter/channel/base_channel.dart';

import '../channel_const.dart';

class GToast with BaseChannel{
  GToast._();
  static GToast _instance;
  static GToast instance() {
    if (_instance == null) {
      _instance = new GToast._();
    }
    return _instance;
  }
  static const MethodChannel _channel = MethodChannel(ToastChannel.CHANNEL_NAME);

  void toast(String msg, {Toast type = Toast.LENGTH_SHORT}) {
    _channel.invokeMethod(
        ToastChannel.TOAST, {ToastChannel.MSG: msg, ToastChannel.TYPE: type == Toast.LENGTH_SHORT ? 0 : 1});
  }
}

enum Toast { LENGTH_SHORT, LENGTH_LONG }
