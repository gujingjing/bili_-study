package com.gjj.test

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter

/**
 * author: gujingjing
 * created on: 2020/10/9 4:33 PM
 * description:
 */
class TestApp : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {         // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()    // 打印日志
            ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)// 尽可
    }
}