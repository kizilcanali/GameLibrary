package com.alikizilcan.gamelib.infra

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun imageUrl(view: ImageView, imageUrl: String){
    if(!imageUrl.isNullOrEmpty()){
        imageUrl.let {
            Glide.with(view.context)
                .load(imageUrl)
                .into(view)
        }
    }
}

@BindingAdapter("textField")
fun textDouble(view: TextView, info:Double){
    view.setText(info.toString())
}