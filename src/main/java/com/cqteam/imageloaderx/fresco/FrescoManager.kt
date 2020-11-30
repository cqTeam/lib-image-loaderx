package com.cqteam.imageloaderx.fresco

import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Author： 洪亮
 * Time： 2020/11/26 - 3:40 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
class FrescoManager private constructor(){

    companion object {
        private var instance: FrescoManager? = null
        fun getInstance(): FrescoManager {
            if (instance == null) instance = FrescoManager()
            return instance!!
        }
    }

    fun init(context: Context){
        Fresco.initialize(context)
    }
}