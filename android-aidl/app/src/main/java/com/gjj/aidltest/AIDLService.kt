package com.gjj.aidltest

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.gjj.framwork.utils.GLogger
import com.gjj.framwork.utils.logDebug

/**
 * author: gujingjing
 * created on: 2020/10/19 5:24 PM
 * description:
 */
class AIDLService : Service(), GLogger {

    private var books = ArrayList<Book>()

    private var stub = object : BookController.Stub() {
        override fun getBookList(): MutableList<Book> {
            logDebug { "client get book list" }
            return books.toMutableList()
        }

        override fun addBookInOut(book: Book?) {
            logDebug { "client add one book ,book is null = ${book == null}" }
            book?.let { books.add(it) }
        }

    }

    override fun onBind(intent: Intent?): IBinder? = stub

    override val logTag: String = "AIDLService"
}