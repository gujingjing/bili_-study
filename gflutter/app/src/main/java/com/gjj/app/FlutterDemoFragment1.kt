package com.gjj.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gjj.flutterlib.BaseFlutterFragment.Companion.getFlutterFragment
import router.Flutter_Demo_Path

/**
 * author: gujingjing
 * created on: 2020/9/1 1:21 PM
 * description:
 */
class FlutterDemoFragment1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_flutter_demo1)

        val flutterFragment: Fragment = getFlutterFragment(Flutter_Demo_Path)
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, flutterFragment, null)
            .commitAllowingStateLoss()
        supportFragmentManager.executePendingTransactions()

    }

    companion object {
        fun intentNew(context: Context) {
            context.startActivity(Intent(context, FlutterDemoFragment1::class.java))
        }
    }
}