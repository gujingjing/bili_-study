package com.gjj.aidltest

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun addIntercepter(){
        application.registerActivityLifecycleCallbacks(object :Application.ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity) {
                TODO("Not yet implemented")
            }

            override fun onActivityStarted(activity: Activity) {
                TODO("Not yet implemented")
            }

            override fun onActivityDestroyed(activity: Activity) {
                TODO("Not yet implemented")
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                TODO("Not yet implemented")
            }

            override fun onActivityStopped(activity: Activity) {
                TODO("Not yet implemented")
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                TODO("Not yet implemented")
            }

            override fun onActivityResumed(activity: Activity) {
                TODO("Not yet implemented")
            }

        })
    }
}