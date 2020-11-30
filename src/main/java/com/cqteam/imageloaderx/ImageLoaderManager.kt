package com.cqteam.imageloaderx

import android.content.Context
import com.cqteam.imageloaderx.fresco.FrescoLoader
import com.cqteam.imageloaderx.fresco.FrescoManager
import com.cqteam.imageloaderx.glide.GlideLoader

/**
 * Author： 洪亮
 * Time： 2020/11/26 - 3:14 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
object ImageLoaderManager {

    const val Loader_Glide = 0
    const val Loader_Fresco = 1

    private lateinit var mImageLoader: ILoader
    private lateinit var mContext: Context

    /**
     *  初始化，在Application中操作
     *  @param context 上下文
     *  @param whichLoader 哪个加载器：Loader_Glide，Loader_Fresco
     */
    fun init(context: Context, whichLoader: Int){
        mContext = context
        FrescoManager.getInstance().init(context)
        when(whichLoader){
            Loader_Fresco -> {
                mImageLoader = FrescoLoader()
            }
            Loader_Glide -> {
                mImageLoader = GlideLoader()
            }
        }
    }

    internal fun getLoader(): ILoader {
        return mImageLoader
    }

    internal fun getContext(): Context {
        return mContext
    }
}