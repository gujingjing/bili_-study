package com.gjj.kotlin.kotlincoroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gjj.framwork.utils.GLogger
import com.gjj.framwork.utils.logDebug
import kotlinx.android.synthetic.main.kotlin_coroutines_activity_kotlin_coroutines_test.*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * author: gujingjing
 * created on: 2020/8/5 2:50 PM
 */
class CoroutinesTestActivity : AppCompatActivity(), GLogger, CoroutineScope by MainScope() {

    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_coroutines_activity_kotlin_coroutines_test)

        asyncTime.setOnClickListener { getTimes() }
        asyncTime2.setOnClickListener {
            launch { getTimes2() }
            launch { getTimes2() }
//            mainScope.launch { getTimes2() }
//            mainScope.launch { getTimes2() }
        }
    }

    private suspend fun getTimes2() = coroutineScope {
        val one = async {
            blockTime(1000)
            logDebug { "one-firstTime" }
        }
        val two = async {
            blockTime(2000)
            logDebug { "two-secondTime" }
        }
        val oneTime = one.await()
        logDebug { "2-allTime: one= $oneTime" }
    }

    private fun getTimes() = runBlocking {
        logDebug { "getTimes start" }
        val times = measureTimeMillis {
            val first = async {
                blockTime(1000)
                logDebug { "firstTime" }
            }
            val second = async {
                blockTime(2000)
                logDebug { "secondTime" }
            }
        }
        logDebug { "allTime= $times" }
    }

    private suspend fun blockTime(sleepTime: Long): Long {
        delay(sleepTime)
//        Thread.sleep(sleepTime)
        return sleepTime
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
//        mainScope.cancel()
    }

    override val logTag: String
        get() = this::class.java.simpleName
}