package com.cqteam.imageloaderx

import android.content.Context
import android.widget.ImageView
import com.cqteam.imageloaderx.glide.GlideLoader
import com.cqteam.imageloaderx.utils.ImageUrlUtils

/**
 * Author： 洪亮
 * Time： 2019-10-24 - 11:32
 * Email：281332545@qq.com
 * <p>
 * 描述： 提供给客户端的门面类
 */
object ImageLoader {

    private val loader: ILoader = ImageLoaderManager.getLoader()

    fun show(imageView: ImageView, url: String){
        loader.load(imageView,
            ImageUrlUtils.handle(url),GlobalConfiguration.placeholderResourceId,GlobalConfiguration.errorResourceId)
    }

    fun showWithDefault( imageView: ImageView, url: String, defaultImgRes :Int){
        loader.load(imageView,
            ImageUrlUtils.handle(url),defaultImgRes,defaultImgRes)
    }

    fun showCircleWithDefault(imageView: ImageView, url: String, defaultImgRes :Int){
        loader.loadCircleImageWithDefault(imageView,ImageUrlUtils.handle(url), defaultImgRes)
    }

    fun show(imageView: ImageView, resourceId: Int) {
        loader.load(imageView,resourceId,GlobalConfiguration.placeholderResourceId,GlobalConfiguration.errorResourceId)
    }

    fun show(imageView: ImageView, resourceId: Int, topLeftRadius: Int, topRightRadius: Int) {
        loader.loadRoundedCornersImage(imageView,resourceId,topLeftRadius,topRightRadius,GlobalConfiguration.placeholderResourceId,GlobalConfiguration.errorResourceId)
    }

    fun show(imageView: ImageView, url: String, topLeftRadius: Int, topRightRadius: Int) {
        loader.loadRoundedCornersImage(imageView,ImageUrlUtils.handle(url),topLeftRadius,topRightRadius,GlobalConfiguration.placeholderResourceId,GlobalConfiguration.errorResourceId)
    }

    fun show(imageView: ImageView, resourceId: Int, radius: Int) {
        loader.loadRoundedCornersImage(imageView,resourceId,radius,GlobalConfiguration.placeholderResourceId,GlobalConfiguration.errorResourceId)
    }

    fun show(imageView: ImageView, url: String, radius: Int) {
        loader.loadRoundedCornersImage(imageView,ImageUrlUtils.handle(url),radius,GlobalConfiguration.placeholderResourceId,GlobalConfiguration.errorResourceId)
    }

    /**
     *  设置ImageUrl的域名
     */
    fun setImageUrlHost(host: String) {
        ImageUrlUtils.imageUrlHost = host
    }
}