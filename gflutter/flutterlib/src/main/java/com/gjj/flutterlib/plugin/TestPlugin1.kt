package com.gjj.flutterlib.plugin

import android.widget.Toast
import com.gjj.framwork.utils.GLogger
import com.gjj.framwork.utils.logInfo
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodChannel

/**
 * author: gujingjing
 * created on: 2020/8/31 1:09 PM
 * description:
 */
class TestPlugin1 : FlutterPlugin, GLogger
//    , ActivityAware
{
    private var channel: MethodChannel? = null

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(binding.binaryMessenger, "flutter_plugin_test_new").apply {
            setMethodCallHandler { call, result ->
                when (call.method) {
                    "testPlugin" -> {
//                        val msg: String? = methodCall.argument("msg")
                        Toast.makeText(binding.applicationContext, "TestPlugin1-testPlugin", Toast.LENGTH_LONG).show()
                        logInfo { "TestPlugin1-testPlugin" }
                        result.success(null)
                    }
                    else -> {
                        Toast.makeText(binding.applicationContext, "TestPlugin1-no no no ", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {

    }

    override val logTag: String = "TestPlugin1"

}