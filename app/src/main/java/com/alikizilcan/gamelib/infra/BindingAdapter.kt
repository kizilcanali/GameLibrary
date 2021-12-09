package com.alikizilcan.gamelib.infra

import android.widget.ImageView
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