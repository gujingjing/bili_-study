package com.gjj.flutterlib.plugin.back

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import com.gjj.flutterlib.plugin.BackChannel
import com.gjj.flutterlib.plugin.base.BaseSinglePlugin
import com.gjj.framwork.utils.logDebug
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

/**
 * author: gujingjing
 * created on: 2020/9/1 11:43 AM
 * description:
 */
class BackPlugin(private val context: Context, private val flutterBack: FlutterBack = DefaultFlutterBack(context)) :
    BaseSinglePlugin(BackChannel.CHANNEL_NAME), ActivityAware {

    override fun callMethod(method: MethodCall, result: MethodChannel.Result) {
        when (method.method) {
            BackChannel.BACK_PRESS -> {
                flutterBack.backPress()
            }
            BackChannel.CLOSE_PAGE -> {
                flutterBack.closePage()
            }
        }
    }

    override fun onDetachedFromActivity() {
        logDebug { "onDetachedFromActivity" }
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        logDebug { "onReattachedToActivityForConfigChanges" }
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        logDebug { "onAttachedToActivity" }
    }

    override fun onDetachedFromActivityForConfigChanges() {
        logDebug { "onDetachedFromActivityForConfigChanges" }
    }

}

interface FlutterBack {
    fun backPress(): Boolean
    fun closePage(): Boolean
}

class DefaultFlutterBack(private val context: Context) : FlutterBack {
    override fun backPress(): Boolean {
        return false
    }

    override fun closePage(): Boolean {
        val activity: Activity = getActivity() ?: return false
        activity.finish()
        return true
    }

    fun getActivity(): Activity? {
        var requestContext = context
        while (requestContext is ContextWrapper) {
            if (requestContext is Activity) {
                return requestContext
            }
            requestContext = requestContext.baseContext
        }
        return null
    }
}