import 'package:flutter/services.dart';
import 'package:flutter/widgets.dart';
import 'package:myflutter/channel/base_channel.dart';
import 'package:myflutter/channel/channel_const.dart';

class GBack with BaseChannel {
  GBack._();

  static GBack _instance;

  static GBack instance() {
    if (_instance == null) {
      _instance = new GBack._();
    }
    return _instance;
  }

  static const MethodChannel _channel = MethodChannel(BackChannel.CHANNEL_NAME);

  void backPress(BuildContext buildContext) {
    if(Navigator.canPop(buildContext)){
      Navigator.pop(buildContext);
    }else{
      closePage();
    }
    // _channel.invokeMethod(BackChannel.BACK_PRESS);
  }

  void closePage() {
    _channel.invokeMethod(BackChannel.CLOSE_PAGE);
  }
}
