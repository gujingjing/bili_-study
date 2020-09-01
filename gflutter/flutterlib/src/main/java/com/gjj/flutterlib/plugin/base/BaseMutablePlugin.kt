package com.gjj.flutterlib.plugin.base

import com.gjj.framwork.utils.GLogger
import io.flutter.embedding.engine.plugins.FlutterPlugin

/**
 * author: gujingjing
 * created on: 2020/8/31 3:05 PM
 * description:
 */
open class BasePlugin : FlutterPlugin, GLogger {

    private val methodChannelFactory: MutableMap<String, MethodChannelFactory> = HashMap()
    private val methodChannels: MutableMap<String, BaseMethodChannel> = HashMap()
    private val methodInterceptors: MutableMap<String, ArrayList<MethodInterceptor>> = HashMap()

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        methodChannelFactory.forEach {
            if (!checkChannelIfNeed(it.key)) return@forEach

            val channel = it.value.createChannel(binding)
            channel.onAttachedToEngine(binding)
            methodInterceptors[channel.channelName]?.forEach { interceptor ->
                channel.addInterceptor(interceptor)
            }
            methodChannels[channel.channelName] = channel
        }
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        methodChannels.forEach {
            it.value.onDetachedFromEngine(binding)
        }
    }

    fun register(channel: MethodChannelFactory) = apply {
        methodChannelFactory[channel.channelName] = channel
    }

    /**
     * 值查找缓存中的channel添加
     */
    fun injectInterceptor(channelName: String, interceptor: MethodInterceptor) {
        val interceptors: ArrayList<MethodInterceptor> = if (methodInterceptors[channelName] == null) {
            val list = arrayListOf<MethodInterceptor>()
            methodInterceptors[channelName] = list
            list
        } else {
            methodInterceptors[channelName]!!
        }
        interceptors.add(interceptor)
    }

    /**
     * 检测是否需要Channel
     */
    private fun checkChannelIfNeed(channelName: String): Boolean {
        return !methodChannels.containsKey(channelName)
    }

    override val logTag: String = this::class.java.simpleName

}