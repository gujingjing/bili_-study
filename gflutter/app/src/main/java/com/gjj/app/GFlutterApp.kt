package com.gjj.app

import android.content.Context
import androidx.multidex.MultiDex
import com.gjj.flutterlib.engine.GFlutterEngineManager
import io.flutter.app.FlutterApplication

/**
 * author: gujingjing
 * created on: 2020/8/27 12:11 PM
 * description:
 */
class GFlutterApp : FlutterApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        GFlutterEngineManager.init(this)
    }

}