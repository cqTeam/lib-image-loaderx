package com.cqteam.imageloaderx.glide

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.cqteam.imageloaderx.ILoader
import com.cqteam.imageloaderx.ImageLoaderManager
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

/**
 * Author： 洪亮
 * Time： 2019-10-24 - 11:34
 * Email：281332545@qq.com
 * <p>
 * 描述：ILoader 的具体实现类，主要使用的是 Glide 框架
 */
internal class GlideLoader : ILoader {

    private val mContext = ImageLoaderManager.getContext()

    override fun load(view: ImageView, url: String) {
        Glide.with(mContext).load(url).into(view)
    }

    override fun load(
        view: ImageView,
        url: String,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        val requestBuilder: RequestBuilder<Drawable> = Glide.with(mContext).load(url)
        if (placeholderResourceId != null) requestBuilder.placeholder(placeholderResourceId)
        if (errorResourceId != null) requestBuilder.error(errorResourceId)
        requestBuilder.into(view)
    }

    override fun load(
        view: ImageView,
        showResourceId: Int?,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        val requestBuilder: RequestBuilder<Drawable> = Glide.with(mContext).load(showResourceId)
        if (placeholderResourceId != null) requestBuilder.placeholder(placeholderResourceId)
        if (errorResourceId != null) requestBuilder.error(errorResourceId)
        requestBuilder.into(view)
    }

    /**
     *  四个圆角
     */
    override fun loadRoundedCornersImage(
        view: ImageView,
        url: String,
        roundingRadius: Int,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        //设置图片圆角角度
        val roundedCorners = RoundedCorners(roundingRadius)
        //通过RequestOptions扩展功能
        val options = RequestOptions.bitmapTransform(roundedCorners as Transformation<Bitmap>)
        val requestBuilder: RequestBuilder<Drawable> = Glide.with(mContext).load(url).apply(options)
        if (placeholderResourceId != null) requestBuilder.placeholder(placeholderResourceId)
        if (errorResourceId != null) requestBuilder.error(errorResourceId)
        requestBuilder.into(view)
    }

    /**
     *  四个圆角
     */
    override fun loadRoundedCornersImage(
        view: ImageView,
        showResourceId: Int?,
        roundingRadius: Int,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        //设置图片圆角角度
        val roundedCorners = RoundedCorners(roundingRadius)
        //通过RequestOptions扩展功能
        val options = RequestOptions.bitmapTransform(roundedCorners as Transformation<Bitmap>)
        val requestBuilder: RequestBuilder<Drawable> = Glide.with(mContext).load(showResourceId).apply(options)
        if (placeholderResourceId != null) requestBuilder.placeholder(placeholderResourceId)
        if (errorResourceId != null) requestBuilder.error(errorResourceId)
        requestBuilder.into(view)
    }

    override fun loadRoundedCornersImage(
        view: ImageView,
        url: String,
        topLeftRadius: Int,
        topRightRadius: Int,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        //设置图片圆角角度
        val roundedCorners1 = RoundedCornersTransformation(topLeftRadius,0, RoundedCornersTransformation.CornerType.TOP_LEFT)
        val roundedCorners2 = RoundedCornersTransformation(topRightRadius,0, RoundedCornersTransformation.CornerType.TOP_RIGHT)
        // 组合
        val mation = MultiTransformation<Bitmap>(roundedCorners1,roundedCorners2)
        //通过RequestOptions扩展功能
        val options = RequestOptions.bitmapTransform(mation)
        val requestBuilder: RequestBuilder<Drawable> = Glide.with(mContext).load(url).apply(options)
        if (placeholderResourceId != null) requestBuilder.placeholder(placeholderResourceId)
        if (errorResourceId != null) requestBuilder.error(errorResourceId)
        requestBuilder.into(view)
    }

    override fun loadRoundedCornersImage(
        view: ImageView,
        showResourceId: Int?,
        topLeftRadius: Int,
        topRightRadius: Int,
        placeholderResourceId: Int?,
        errorResourceId: Int?
    ) {
        //设置图片圆角角度
        val roundedCorners1 = RoundedCornersTransformation(topLeftRadius,0, RoundedCornersTransformation.CornerType.TOP_LEFT)
        val roundedCorners2 = RoundedCornersTransformation(topRightRadius,0, RoundedCornersTransformation.CornerType.TOP_RIGHT)
        // 组合
        val mation = MultiTransformation<Bitmap>(roundedCorners1,roundedCorners2)
        //通过RequestOptions扩展功能
        val options = RequestOptions.bitmapTransform(mation)
        val requestBuilder: RequestBuilder<Drawable> = Glide.with(mContext).load(showResourceId).apply(options)
        if (placeholderResourceId != null) requestBuilder.placeholder(placeholderResourceId)
        if (errorResourceId != null) requestBuilder.error(errorResourceId)
        requestBuilder.into(view)
    }

    override fun loadCircleImageWithDefault(
        imageView: ImageView,
        url: String,
        defaultImgRes: Int
    ) {
        Glide.with(mContext).load(url).apply(RequestOptions.bitmapTransform(
            CircleCrop()
        )).placeholder(defaultImgRes).error(defaultImgRes).into(imageView)
    }

    override fun loadCircleImageWithDefault(
        imageView: ImageView,
        showResourceId: Int?,
        defaultImgRes: Int
    ) {
        Glide.with(mContext).load(showResourceId).apply(RequestOptions.bitmapTransform(
            CircleCrop()
        )).placeholder(defaultImgRes).error(defaultImgRes).into(imageView)
    }
}