package com.gjj.flutterlib

import android.content.Context
import android.content.Intent
import com.gjj.flutterlib.plugin.back.BackPlugin
import com.gjj.flutterlib.plugin.toast.ToastPlugin
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import io.flutter.embedding.engine.FlutterEngine

/**
 * author: gujingjing
 * created on: 2020/8/27 11:49 AM
 * description:
 */
open class BaseFlutterActivity : FlutterActivity() {

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        flutterEngine.plugins.add(ToastPlugin(this))
        flutterEngine.plugins.add(BackPlugin(this))

        initFlutterEngine(flutterEngine)
    }

    open fun initFlutterEngine(flutterEngine: FlutterEngine) {

    }

    companion object {
        val FlutterRouterPath = "FlutterRouterPath"
        fun newIntent(
            context: Context, initialRoute: String,
            clazz: Class<out BaseFlutterActivity> = BaseFlutterActivity::class.java
        ): Intent {
            return NewEngineIntentBuilder(clazz)
                .initialRoute(initialRoute)
                .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                .build(context)
        }

    }
}