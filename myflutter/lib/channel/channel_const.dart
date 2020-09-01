import 'package:myflutter/channel/backpress/channel_backpress.dart';
import 'package:myflutter/channel/base_channel.dart';
import 'package:myflutter/channel/toast/channel_toast.dart';

class ToastChannel {
  static const String CHANNEL_NAME = 'flutter://channel/toast';

  //method
  static const String TOAST = 'toast';

  //param
  static const String MSG = 'msg'; //string
  static const String TYPE = 'type'; //int
}

class BackChannel {
  static const String CHANNEL_NAME = 'flutter://channel/back';

  //method
  static const String BACK_PRESS = 'back_press'; //返回
  static const String CLOSE_PAGE = 'close_page'; //关闭native当前页面
}

//所有channel集合
List<BaseChannel> CHANNEL_LIST = [
  GToast.instance(),
  GBack.instance()
];
