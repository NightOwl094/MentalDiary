package com.nightowl094.mylibrary.functions

import android.util.Log

fun logCurrentError(e: Exception) = Log.e("LJW-ERROR", "${object {}.javaClass.enclosingClass?.name} :: ${object {}.javaClass.enclosingMethod?.name} :: $e")