package com.example.toast_plugin

import android.content.Context
import android.widget.Toast
import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

/** ToastPlugin */
public class ToastPlugin : FlutterPlugin, MethodCallHandler {

    private lateinit var channel: MethodChannel
    private var context: Context? = null

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel =
            MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "toast_plugin")
        context = flutterPluginBinding.applicationContext
        channel.setMethodCallHandler(this);
    }

    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "toast_plugin")
            channel.setMethodCallHandler(ToastPlugin())
        }
    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        when (call.method) {
            "getPlatformVersion" -> {
                result.success("Android ${android.os.Build.VERSION.RELEASE}")
            }
            "toast" -> {
                context?.let {
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
            else -> {
                result.notImplemented()
            }
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }
}
