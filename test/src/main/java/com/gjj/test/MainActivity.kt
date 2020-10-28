package com.gjj.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.gjj.framwork.utils.launchActivity
import com.gjj.kotlin.kotlincoroutines.CoroutinesTestActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = MAIN_PAGE, group = G_GROUP)
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

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

        rxTest()
    }

    private fun rxTest() {
        Observable.just("")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Observable.just("")
            }
            .subscribe()


        Observable.create<Int> {
            it.onNext(0)
            Log.d(TAG, "Observable: current Thread = ${Thread.currentThread().name}")
        }
            .subscribeOn(Schedulers.single())
            .map {
                Log.i(TAG, "${it.inc()} source")
                Log.d(TAG, "map: current Thread = ${Thread.currentThread().name}")
                it.inc()
            }
            .subscribeOn(Schedulers.newThread())
            .map {
                Log.i(TAG, "${it.inc()} source")
                Log.d(TAG, "map: current Thread = ${Thread.currentThread().name}")
                it.inc()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.i(TAG, "${it.inc()} source")
                Log.d(TAG, "Observer: current Thread = ${Thread.currentThread().name}")
            }
    }
}
