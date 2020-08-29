package com.gjj.framwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun test(view: View,listener:View.OnClickListener){
        view.setOnClickListener {
            listener.onClick(it)
        }
    }
}