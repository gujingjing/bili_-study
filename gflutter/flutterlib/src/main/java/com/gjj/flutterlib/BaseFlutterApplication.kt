package com.gjj.flutterlib

import com.gjj.flutterlib.engine.GFlutterEngineManager
import io.flutter.app.FlutterApplication

/**
 * author: gujingjing
 * created on: 2020/8/29 6:44 PM
 * description:
 */
open class BaseFlutterApplication : FlutterApplication() {

    override fun onCreate() {
        super.onCreate()
        GFlutterEngineManager.init(this)
    }
}