package com.gjj.flutterlib.channel.util

import android.content.Context
import android.widget.Toast
import com.gjj.flutterlib.plugin.base.MethodInterceptor
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

/**
 * author: gujingjing
 * created on: 2020/8/29 4:33 PM
 * description:
 */
class ToastMethodInterceptor(private val context: Context) :
    MethodInterceptor {
    override fun onIntercept(methodCall: MethodCall, result: MethodChannel.Result): Boolean {
        if (UtilMethodChannel.METHOD_NAME_TOAST == methodCall.method) {
            Toast.makeText(context, "ToastMethodInterceptor-测试", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    override val methodName: String = UtilMethodChannel.METHOD_NAME_TOAST
}