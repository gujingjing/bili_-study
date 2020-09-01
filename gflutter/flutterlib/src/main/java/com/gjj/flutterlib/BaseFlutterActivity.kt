package com.gjj.flutterlib

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

/**
 * author: gujingjing
 * created on: 2020/8/27 11:49 AM
 * description:
 */
open class BaseFlutterActivity : FlutterActivity() {

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        initFlutter(flutterEngine)
    }

    open fun initFlutter(flutterEngine: FlutterEngine) {

    }

    companion object {
        val FlutterRouterPath = "FlutterRouterPath"
    }
}