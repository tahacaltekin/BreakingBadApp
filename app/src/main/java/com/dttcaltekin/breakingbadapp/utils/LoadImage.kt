package com.dttcaltekin.breakingbadapp.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.request.RequestOptions
import com.dttcaltekin.breakingbadapp.R


fun ImageView.loadImage(img : String, progressDrawable: CircularProgressDrawable) {

    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_launcher_background)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(img)
        .into(this)
}

fun placeHolderProgressBar(context: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}