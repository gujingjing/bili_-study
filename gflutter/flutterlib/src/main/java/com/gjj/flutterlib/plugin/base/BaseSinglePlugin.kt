package com.gjj.flutterlib.plugin.base

import com.gjj.framwork.utils.GLogger
import com.gjj.framwork.utils.logInfo
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

/**
 * author: gujingjing
 * created on: 2020/8/31 4:46 PM
 * description:
 */
open abstract class BaseSinglePlugin(private val channelName: String) : FlutterPlugin, GLogger {

    var channel: MethodChannel? = null

    private val methodHandle =
        MethodChannel.MethodCallHandler { method, result ->
            logInfo { "onMethodCall- method=${method.method}" }
            callMethod(method, result)
        }

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(binding.binaryMessenger, channelName)
        channel?.setMethodCallHandler(methodHandle)
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel?.setMethodCallHandler(null)
    }

    override val logTag: String = this::class.java.simpleName

    abstract fun callMethod(method: MethodCall, result: MethodChannel.Result)
}