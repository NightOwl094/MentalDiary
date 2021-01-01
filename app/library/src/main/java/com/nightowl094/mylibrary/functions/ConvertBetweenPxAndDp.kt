package com.nightowl094.mylibrary.functions

import android.content.res.Resources

fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()

fun convertDp(px: Int): Int = (px / Resources.getSystem().displayMetrics.density).toInt()
fun convertPx(dp: Int): Int = (dp * Resources.getSystem().displayMetrics.density).toInt()
