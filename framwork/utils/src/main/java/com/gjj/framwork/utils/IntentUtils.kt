package com.gjj.framwork.utils

import android.app.Application
import android.content.Context
import android.content.Intent

fun launchActivity(context: Context,clazz: Class<*>){
    val intent=Intent(context,clazz)
    if(context is Application){
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    context.startActivity(intent)
}