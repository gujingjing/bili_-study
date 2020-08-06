package com.gjj.kotlin.kotlincoroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gjj.framwork.utils.GLogger
import com.gjj.framwork.utils.logDebug
import com.gjj.framwork.utils.logInfo
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

        logDebug { "main start" }

        asyncTime.setOnClickListener { getTimes() }
        asyncTime2.setOnClickListener {
            launch { getTimes2() }
//            mainScope.launch { getTimes2() }
        }
        asyncTime3.setOnClickListener { getTimes3() }
        runBlock.setOnClickListener {
            logDebug { "runBlock start" }
            runBlock()
            logDebug { "runBlock end" }
        }
        runBlock()
        logDebug { "main end" }
    }

    private fun runBlock() = runBlocking {
        delay(1000)
        logDebug { "runBlock end time" }
    }

    /**
     * 启动其他协程并不会挂起当前协程
     */
    private fun getTimes3() {
        // 创建一个单线程的协程调度器，下面两个协程都运行在这同一线程上
        val coroutineDispatcher = newSingleThreadContext("ctx")
        // 启动协程 1
        logDebug { "getTimes3 start 0" }
        val one = async(coroutineDispatcher) {
            delay(200)
        }
        // 启动协程 2
        logDebug { "getTimes3 start 1" }
        launch(coroutineDispatcher) {
            delay(100)
        }
        logDebug { "getTimes3 start 2" }

    }

    private suspend fun getTimes2() = coroutineScope {
        val one = async {
            blockTime(1000)
            logDebug { "one-firstTime" }
        }
        one.await()
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
                logInfo { "secondTime" }
            }

            val third = blockTime(2000)
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
        get() = this::class.java.simpleName + "-"
}