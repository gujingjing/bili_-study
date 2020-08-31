package com.gjj.flutterlib

import android.content.Context
import com.gjj.flutterlib.engine.GFlutterEngineManager
import com.gjj.flutterlib.plugin.TestPlugin
import com.gjj.flutterlib.plugin.TestPlugin1
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import io.flutter.embedding.engine.FlutterEngine
import router.Flutter_Demo_Path

/**
 * author: gujingjing
 * created on: 2020/8/27 11:50 AM
 * description:
 */
class FlutterDemoPage1 : FlutterActivity() {

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        flutterEngine.plugins.add(TestPlugin())
        flutterEngine.plugins.add(TestPlugin1())

//        GeneratedPluginRegistrant.registerWith(flutterEngine)
    }

    companion object {
        fun intentNew(context: Context) {
            val intent = NewEngineIntentBuilder(FlutterDemoPage1::class.java)
                .initialRoute(Flutter_Demo_Path)
                .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                .build(context)
            context.startActivity(intent)
        }

        fun intentCache(context: Context) {
            val intent = CachedEngineIntentBuilder(FlutterDemoPage1::class.java, GFlutterEngineManager.DEMO_ENGINE)
                .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                .build(context)
                .apply {
                    putExtra("route", Flutter_Demo_Path)
                }
            context.startActivity(intent)
        }
    }
}