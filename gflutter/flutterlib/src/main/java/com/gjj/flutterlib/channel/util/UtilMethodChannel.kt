package com.gjj.flutterlib.channel.util

import android.content.Context
import com.gjj.flutterlib.plugin.base.BaseMethodChannel
import io.flutter.plugin.common.BinaryMessenger

/**
 * author: gujingjing
 * created on: 2020/8/29 4:26 PM
 * description:
 */
class UtilMethodChannel(context: Context, binaryMessenger: BinaryMessenger) : BaseMethodChannel(binaryMessenger) {

    override val channelName: String = CHANNEL_NAME

    init {
        addInterceptor(ToastMethodInterceptor(context))
    }

    companion object {
        const val CHANNEL_NAME = "gjj.flutter.util"
        const val METHOD_NAME_TOAST = "toast"
    }
}