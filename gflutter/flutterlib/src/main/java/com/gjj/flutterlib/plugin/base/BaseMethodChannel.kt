package com.gjj.flutterlib.plugin.base

import androidx.annotation.UiThread
import com.gjj.framwork.utils.GLogger
import com.gjj.framwork.utils.logInfo
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

abstract class BaseMethodChannel(binaryMessenger: BinaryMessenger) : GLogger {

    override val logTag: String = this::class.java.simpleName

    abstract val channelName: String

    //methodChannel拦截器
    private val interceptors: MutableMap<String, MethodInterceptor> = HashMap()
    private val methodChannel = MethodChannel(binaryMessenger, channelName)

    private val methodHandle = object : MethodChannel.MethodCallHandler {
        override fun onMethodCall(method: MethodCall, result: MethodChannel.Result) {
            logInfo { "onMethodCall- method=${method.method}" }
            run breaking@{
                interceptors.forEach {
                    if (it.value.onIntercept(method, result)) {
                        return@breaking
                    }
                }
            }
        }
    }

    @UiThread
    fun invokeMethod(method: String, arguments: Any?, callback: MethodChannel.Result? = null) {
        if (callback == null) {
            methodChannel.invokeMethod(method, arguments)
        } else {
            methodChannel.invokeMethod(method, arguments, callback)
        }
    }

    fun addInterceptor(interceptor: MethodInterceptor) {
        if (interceptors[interceptor.methodName] != null) {
            //TODO debug throw
            return
        }
        interceptors[interceptor.methodName] = interceptor
    }

    fun addInterceptors(interceptors: MutableMap<String, MethodInterceptor>) {
        this.interceptors.putAll(interceptors)
    }

    fun removeInterceptor(key: String) {
        interceptors.remove(key)
    }

    /************************************************以下为生命周期************************************************/
    //对标FlutterPlugin中的onAttachedToEngine时机
    open fun onAttachedToEngine(binding: FlutterPluginBinding) {
        methodChannel.setMethodCallHandler(methodHandle)
    }

    //对标FlutterPlugin中的onDetachedFromEngine时机
    open fun onDetachedFromEngine(binding: FlutterPluginBinding) {
//        methodChannel.setMethodCallHandler(null)
    }

}

abstract class MethodChannelFactory {
    abstract val channelName: String
    abstract fun createChannel(binding: FlutterPlugin.FlutterPluginBinding): BaseMethodChannel
}

interface MethodInterceptor {
    fun onIntercept(methodCall: MethodCall, result: MethodChannel.Result): Boolean
    val methodName: String
}
