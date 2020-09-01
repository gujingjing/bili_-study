package com.gjj.flutterlib.plugin.toast

import android.content.Context
import android.widget.Toast
import com.gjj.flutterlib.plugin.ChannelCode
import com.gjj.flutterlib.plugin.ToastChannel
import com.gjj.flutterlib.plugin.base.BaseSinglePlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

/**
 * author: gujingjing
 * created on: 2020/8/31 7:45 PM
 * description:
 */
class ToastPlugin(private val context: Context) : BaseSinglePlugin(ToastChannel.CHANNEL_NAME) {

    override fun callMethod(call: MethodCall, result: MethodChannel.Result) {
        when (call.method) {
            ToastChannel.TOAST -> {
                val msg: String? = call.argument("msg")
                val type: Int = call.argument("type") ?: Toast.LENGTH_SHORT
                if (msg.isNullOrEmpty()) {
                    result.error(ChannelCode.PARAM_ERROR, "toast msg is empty", null)
                } else {
                    Toast.makeText(context, msg, type).show()
                    result.success("success")
                }
            }
        }
    }
}