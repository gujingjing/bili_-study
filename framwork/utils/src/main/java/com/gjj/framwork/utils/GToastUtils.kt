package com.gjj.framwork.utils

import android.content.Context
import android.widget.Toast

/**
 * author: gujingjing
 * created on: 2020/8/29 4:37 PM
 * description:
 */

fun toast(context: Context , msg:String , duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText( context ,msg , duration ).show()
}