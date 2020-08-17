package com.gjj.bilistudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gjj.framwork.utils.launchActivity
import com.gjj.kotlin.kotlincoroutines.CoroutinesTestActivity
import kotlinx.android.synthetic.main.app_activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_main)

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