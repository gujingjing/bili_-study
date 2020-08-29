package com.gjj.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gjj.flutterlib.FlutterDemoPage1
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flutter1.setOnClickListener { jumpFlutterPage1() }
        flutter2.setOnClickListener { jumpFlutterPage2() }
    }

    private fun jumpFlutterPage1() {
        FlutterDemoPage1.intentNew(this)
    }

    private fun jumpFlutterPage2() {
        FlutterDemoPage1.intentCache(this)
    }
}
