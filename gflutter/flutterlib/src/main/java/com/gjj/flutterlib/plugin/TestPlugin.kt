package com.gjj.flutterlib.plugin

import com.gjj.flutterlib.channel.BaseMethodChannel
import com.gjj.flutterlib.channel.util.UtilMethodChannel
import io.flutter.embedding.engine.plugins.FlutterPlugin

/**
 * author: gujingjing
 * created on: 2020/8/29 5:24 PM
 * description:
 */
class TestPlugin : FlutterPlugin {

    private val channels: MutableMap<String, BaseMethodChannel> = HashMap()

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        val binaryMessenger = binding.binaryMessenger
        val method = UtilMethodChannel(binding.applicationContext, binaryMessenger)
        channels[method.channelName] = method
        method.onAttachedToEngine(binding)
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channels.forEach {
            it.value.onDetachedFromEngine(binding)
        }
    }

}