package com.gjj.aidlclient

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gjj.aidltest.Book
import com.gjj.aidltest.BookController
import com.gjj.framwork.utils.GLogger
import com.gjj.framwork.utils.logDebug
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), GLogger {

    private var bookController: BookController? = null

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            bookController = BookController.Stub.asInterface(service)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBook.setOnClickListener {
            bookController?.addBookInOut(Book())
        }
        getBook.setOnClickListener {
            logDebug {
                val books = bookController?.bookList
                "get book size is: ${books?.size}"
            }
        }
        bindService()
    }

    private fun bindService() {
        val intent = Intent()
        intent.setPackage("com.gjj.aidltest")
        intent.action = "com.gjj.aidltest"
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override val logTag: String = "client-MainActivity"

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        logDebug { "onStop" }
        Log.i("client-","onStop")
    }

    override fun onStart() {
        super.onStart()
        logDebug { "onStart" }
        Log.i("client-","onStart")
    }
}
