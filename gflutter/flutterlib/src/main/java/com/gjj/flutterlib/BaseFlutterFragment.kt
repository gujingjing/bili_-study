package com.gjj.flutterlib

import com.gjj.flutterlib.plugin.back.BackPlugin
import com.gjj.flutterlib.plugin.toast.ToastPlugin
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.RenderMode
import io.flutter.embedding.android.TransparencyMode
import io.flutter.embedding.engine.FlutterEngine

/**
 * author: gujingjing
 * created on: 2020/8/29 3:16 PM
 * description:
 */
class BaseFlutterFragment : FlutterFragment() {

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        flutterEngine.plugins.add(ToastPlugin(context))
        flutterEngine.plugins.add(BackPlugin(context))

        initFlutterEngine(flutterEngine)
    }

    open fun initFlutterEngine(flutterEngine: FlutterEngine) {

    }

    companion object {
        fun getFlutterFragment(
            initialRoute: String,
            clazz: Class<out BaseFlutterFragment> = BaseFlutterFragment::class.java
        ): FlutterFragment {
            return NewEngineFragmentBuilder(clazz)
                .initialRoute(initialRoute)
                .renderMode(RenderMode.texture)
                .transparencyMode(TransparencyMode.transparent)
                .build<BaseFlutterFragment>()
        }
    }
}