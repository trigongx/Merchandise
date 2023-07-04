package com.example.merchandise.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.BaseRequestOptions

fun ImageView.loadImage(url: String){
    Glide.with(this).load(url).into(this)//override(200, 200)
}