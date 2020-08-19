package com.gjj.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gjj.framwork.utils.launchActivity
import com.gjj.kotlin.kotlincoroutines.CoroutinesTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //协程
        kotlin_coroutine.setOnClickListener {
            launchActivity(
                this,
                CoroutinesTestActivity::class.java
            )
        }

        recyclerView_test.setOnClickListener {
            launchActivity(
                this,
                RecyclerViewTestActivity::class.java
            )
        }
    }


}
