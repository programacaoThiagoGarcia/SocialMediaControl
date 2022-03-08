package com.example.socialmediacontrol.android.modules.ui.adapters.bindadapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import com.squareup.picasso.Picasso

@BindingAdapter("android:animatedVisibility")
fun setAnimatedVisibility(target: View, isVisible: Boolean) {
    target.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("android:imageUrl")
fun loadImage(view: ImageView, url: String) {
    Picasso.get().load(url).into(view)
}





