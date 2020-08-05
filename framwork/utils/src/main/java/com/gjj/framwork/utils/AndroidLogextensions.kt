package com.gjj.framwork.utils

import android.util.Log

/**
 * author: gujingjing
 * created on: 2020/8/5 4:06 PM
 * description: [GLogger]辅助类，省去打日志时的tag参数
 */

interface GLogger {
    val logTag: String
}

inline fun GLogger.logInfo(throwable: Throwable? = null, noinline block: () -> String?) {
    block?.invoke()?.let {
        Log.i(logTag, it)
    }
}

inline fun GLogger.logDebug(throwable: Throwable? = null, noinline block: () -> String?) {
    block?.invoke()?.let {
        Log.d(logTag, it)
    }
}

inline fun GLogger.logWarn(throwable: Throwable? = null, noinline block: () -> String?) {
    block?.invoke()?.let {
        Log.w(logTag, it)
    }
}

inline fun GLogger.logError(throwable: Throwable? = null, noinline block: () -> String?) {
    block?.invoke()?.let {
        Log.e(logTag, it)
    }
}
