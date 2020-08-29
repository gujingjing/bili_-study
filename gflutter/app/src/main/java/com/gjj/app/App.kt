package com.gjj.app

import android.content.Context
import androidx.multidex.MultiDex
import com.gjj.flutterlib.BaseFlutterApplication

/**
 * author: gujingjing
 * created on: 2020/8/27 12:11 PM
 * description:
 */
class App : BaseFlutterApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    
}