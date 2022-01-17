package com.alikizilcan.gamelib.infra

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun imageUrl(view: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(view.context)
            .load(imageUrl)
            .into(view)
    }
}

@BindingAdapter("isVisible")
fun isVisible(view: View, state: Boolean){
    view.isVisible = state
}

@BindingAdapter("visibilityWhenSearch")
fun changeVisibility(view: View, query: String){
    view.isVisible = query.length < 3
}
