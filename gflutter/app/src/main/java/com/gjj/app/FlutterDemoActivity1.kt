package com.gjj.app

import android.content.Context
import com.gjj.flutterlib.BaseFlutterActivity
import com.gjj.flutterlib.engine.GFlutterEngineManager
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import router.Flutter_Demo_Path

/**
 * author: gujingjing
 * created on: 2020/9/1 1:19 PM
 * description:
 */
class FlutterDemoActivity1 : BaseFlutterActivity() {

    companion object {
        fun intentNew(context: Context) {
            val intent = newIntent(context, Flutter_Demo_Path)
            context.startActivity(intent)
        }

        fun intentCache(context: Context) {
            val intent = CachedEngineIntentBuilder(FlutterDemoActivity1::class.java, GFlutterEngineManager.DEMO_ENGINE)
                .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                .build(context)
                .apply {
                    putExtra("route", Flutter_Demo_Path)
                }
            context.startActivity(intent)
        }
    }
}