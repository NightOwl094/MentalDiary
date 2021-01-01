package com.nightowl094.mylibrary.functions

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.nightowl094.mylibrary.R
import java.io.File

fun ImageView.loadUrl(url: String?, @DrawableRes placeholder: Int = R.drawable.ic_empty, context: Context? = null) {
    val c = context?.run { this } ?: this.context

    try {
        Glide.with(c)
            .load(url)
            .placeholder(ContextCompat.getDrawable(c, placeholder))
            .error(ContextCompat.getDrawable(c, R.drawable.ic_empty))
            .into(this)
    } catch (e: OutOfMemoryError) {
        Toast.makeText(c, "out of memory", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        logCurrentError(e)
    }

}

fun ImageView.loadImage(drawable: Drawable, @DrawableRes placeholder: Int = R.drawable.ic_empty, context: Context? = null) {
    val c = context?.run { this } ?: this.context

    try {
        Glide.with(c)
            .load(drawable)
            .placeholder(ContextCompat.getDrawable(c, placeholder))
            .error(ContextCompat.getDrawable(c, R.drawable.ic_empty))
            .into(this)
    } catch (e: OutOfMemoryError) {
        Toast.makeText(c, "out of memory", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        logCurrentError(e)
    }
}

fun ImageView.loadImageById(@DrawableRes drawable: Int, @DrawableRes placeholder: Int = R.drawable.ic_empty, context: Context? = null) {
    val c = context?.run { this } ?: this.context

    try {
        Glide.with(c)
            .load(ContextCompat.getDrawable(c, drawable))
            .placeholder(ContextCompat.getDrawable(c, placeholder))
            .error(ContextCompat.getDrawable(c, R.drawable.ic_empty))
            .into(this)
    } catch (e: OutOfMemoryError) {
        Toast.makeText(c, "out of memory", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        logCurrentError(e)
    }
}

fun ImageView.loadUri(uri: Uri, @DrawableRes placeholder: Int = R.drawable.ic_empty, context: Context? = null) {
    val c = context?.run { this } ?: this.context

    try {
        Glide.with(c)
            .load(uri)
            .placeholder(ContextCompat.getDrawable(c, placeholder))
            .error(ContextCompat.getDrawable(c, R.drawable.ic_empty))
            .into(this)
    } catch (e: OutOfMemoryError) {
        Toast.makeText(c, "out of memory", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        logCurrentError(e)
    }
}

fun ImageView.loadBitmap(bitmap: Bitmap, @DrawableRes placeholder: Int = R.drawable.ic_empty, context: Context? = null) {
    val c = context?.run { this } ?: this.context

    try {
        Glide.with(c)
            .load(bitmap)
            .placeholder(ContextCompat.getDrawable(c, placeholder))
            .error(ContextCompat.getDrawable(c, R.drawable.ic_empty))
            .into(this)
    } catch (e: OutOfMemoryError) {
        Toast.makeText(c, "out of memory", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        logCurrentError(e)
    }
}


fun ImageView.loadString(string: String, @DrawableRes placeholder: Int = R.drawable.ic_empty, context: Context? = null) {
    val c = context?.run { this } ?: this.context

    try {
        Glide.with(c)
            .load(string)
            .placeholder(ContextCompat.getDrawable(c, placeholder))
            .error(ContextCompat.getDrawable(c, R.drawable.ic_empty))
            .into(this)
    } catch (e: OutOfMemoryError) {
        Toast.makeText(c, "out of memory", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        logCurrentError(e)
    }
}

fun ImageView.loadFile(file: File, @DrawableRes placeholder: Int = R.drawable.ic_empty, context: Context? = null) {
    val c = context?.run { this } ?: this.context

    try {
        Glide.with(c)
            .load(file)
            .placeholder(ContextCompat.getDrawable(c, placeholder))
            .error(ContextCompat.getDrawable(c, R.drawable.ic_empty))
            .into(this)
    } catch (e: OutOfMemoryError) {
        Toast.makeText(c, "out of memory", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        logCurrentError(e)
    }
}