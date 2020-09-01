package com.gjj.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flutter1.setOnClickListener { jumpFlutterPage1() }
        flutter2.setOnClickListener { jumpFlutterPage2() }
        flutter3.setOnClickListener { jumpFlutterPage3() }
    }

    private fun jumpFlutterPage1() {
        FlutterDemoActivity1.intentNew(this)
    }

    private fun jumpFlutterPage2() {
        FlutterDemoActivity1.intentCache(this)
    }

    private fun jumpFlutterPage3() {
        FlutterDemoFragment1.intentNew(this)
    }
}
