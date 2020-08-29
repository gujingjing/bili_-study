package com.gjj.app

import androidx.multidex.MultiDexApplication
import com.gjj.flutterlib.engine.GFlutterEngineManager

/**
 * author: gujingjing
 * created on: 2020/8/27 12:11 PM
 * description:
 */
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        GFlutterEngineManager.init(this)
    }

}