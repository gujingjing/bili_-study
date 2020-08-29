package com.gjj.flutterlib.engine

import android.content.Context
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import router.HomeRouter

/**
 * author: gujingjing
 * created on: 2020/8/27 11:59 AM
 * description:
 */
object GFlutterEngineManager {

    const val DEMO_ENGINE = "demo_engine"

    fun init(context: Context) {
        cacheEngine(context, DEMO_ENGINE)
    }

    fun getDemoEngine(context: Context) = cacheEngine(context, DEMO_ENGINE)

    /**
     * 根据key获取引擎缓存
     */
    fun cacheEngine(engineKey: String): FlutterEngine? {
        return FlutterEngineCache
            .getInstance()
            .get(engineKey)
    }

    /**
     * 根据缓存获取，若无，创建新engine
     */
    fun cacheEngine(
        context: Context,
        engineKey: String,
        initialRoute: String = HomeRouter
    ): FlutterEngine {
        val engine = FlutterEngine(context)
//        engine.navigationChannel.setInitialRoute(initialRoute)
        engine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )
        FlutterEngineCache
            .getInstance()
            .put(engineKey, engine)
        return engine
    }

}