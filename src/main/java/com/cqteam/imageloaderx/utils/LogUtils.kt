package com.cqteam.imageloaderx.utils

import android.util.Log

/**
 * Author： 洪亮
 * Time： 2020/11/26 - 3:59 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
internal object LogUtils {

    private const val logTag = "imageloaderx-log"

    private var isShow = true

    fun isDebug(debug: Boolean){
        isShow = debug
    }

    fun e(message: String, tag: String = logTag){
        if (isShow) Log.e(tag,message)
    }

    fun d(message: String, tag: String = logTag){
        if (isShow) Log.d(tag,message)
    }

    fun i(message: String, tag: String = logTag){
        if (isShow) Log.i(tag,message)
    }

    fun w(message: String, tag: String = logTag){
        if (isShow) Log.w(tag,message)
    }
}