package com.gjj.flutterlib.plugin

/**
 * author: gujingjing
 * created on: 2020/8/31 7:45 PM
 * description:
 */

class ToastChannel {
    companion object {
        const val CHANNEL_NAME = "flutter://channel/toast"
        const val TOAST = "toast"
    }
}

class BackChannel {
    companion object {
        const val CHANNEL_NAME = "flutter://channel/back"
        const val BACK_PRESS = "back_press"
        const val CLOSE_PAGE = "close_page"
    }
}

class ChannelCode {
    companion object {
        const val PARAM_ERROR = "param_error" //参数错误
    }
}
