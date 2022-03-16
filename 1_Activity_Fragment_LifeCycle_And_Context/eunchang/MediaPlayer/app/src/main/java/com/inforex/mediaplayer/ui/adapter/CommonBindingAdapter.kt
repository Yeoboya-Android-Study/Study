package com.inforex.mediaplayer.ui.adapter

import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.inforex.mediaplayer.util.ImageUtil


object CommonBindingAdapter {

    @BindingAdapter("onClickListener")
    @JvmStatic
    fun setOnClickListener(view: View, listener: View.OnClickListener?) {
        view.setOnClickListener(listener)
    }

    @BindingAdapter(value = ["imageURL", "defaultResId"], requireAll = false)
    @JvmStatic
    fun setImage(imageView: ImageView, url: String?, @DrawableRes defaultImg: Int? = null) {
        url?.takeIf { it.isNotEmpty() }?.let {
            val defaultResId = defaultImg ?: 0
            ImageUtil.setImage(imageView.context, imageView, it, defaultResId)
        } ?: run {
            defaultImg?.let { ImageUtil.setImage(imageView.context, imageView, it) }
        }
    }

    @BindingAdapter(value = ["imageFile", "defaultResId"], requireAll = false)
    @JvmStatic
    fun setImage(imageView: ImageView, file: Any?, @DrawableRes defaultImg: Int? = null) {

        file?.let {
            if (it is Uri) {
                val defaultResId = defaultImg ?: 0
                ImageUtil.setImage(imageView.context, imageView, it, defaultResId = defaultResId)
            } else {
                Log.i("qwe123", "CommonBindingAdapter.setImage():::")
                val defaultResId = defaultImg ?: 0
                ImageUtil.setImage(imageView.context, imageView, it.toString(), defaultResId = defaultResId)
            }
        } ?: run {
            defaultImg?.let { ImageUtil.setImage(imageView.context, imageView, it) }
        }
    }
}