package com.cqteam.imageloaderx.fresco

import android.content.Context
import android.widget.ImageView
import com.cqteam.imageloaderx.ILoader
import com.cqteam.imageloaderx.fresco.view.XSimpleDraweeView
import com.cqteam.imageloaderx.utils.LogUtils
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Author： 洪亮
 * Time： 2020/11/26 - 3:13 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
class FrescoLoader: ILoader {
    override fun load(view: ImageView, url: String) {
        if (view is SimpleDraweeView){
            view.setImageURI(url)
        } else {
            LogUtils.i("Fresco loader must use SimpleDraweeView")
        }
    }

    override fun load(
        view: ImageView,
        url: String,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        if (view is SimpleDraweeView){
            if (placeholderResourceId != null) view.hierarchy.setPlaceholderImage(placeholderResourceId)
            view.setImageURI(url)
        } else {
            LogUtils.e("Fresco loader must use SimpleDraweeView")
        }
    }

    override fun load(
        view: ImageView,
        showResourceId: Int?,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        TODO("Not yet implemented")
    }

    override fun loadRoundedCornersImage(
        view: ImageView,
        showResourceId: Int?,
        roundingRadius: Int,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        TODO("Not yet implemented")
    }

    override fun loadRoundedCornersImage(
        view: ImageView,
        url: String,
        roundingRadius: Int,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        TODO("Not yet implemented")
    }

    override fun loadRoundedCornersImage(
        view: ImageView,
        url: String,
        topLeftRadius: Int,
        topRightRadius: Int,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        TODO("Not yet implemented")
    }

    override fun loadRoundedCornersImage(
        view: ImageView,
        showResourceId: Int?,
        topLeftRadius: Int,
        topRightRadius: Int,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        TODO("Not yet implemented")
    }

    override fun loadCircleImageWithDefault(imageView: ImageView, url: String, defaultImgRes: Int) {
        TODO("Not yet implemented")
    }

    override fun loadCircleImageWithDefault(
        imageView: ImageView,
        showResourceId: Int?,
        defaultImgRes: Int
    ) {
        TODO("Not yet implemented")
    }
}