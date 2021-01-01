package com.nightowl094.mylibrary.functions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

// # Nav Controller
fun FragmentActivity.getNavController(navHostId: Int): NavController =
    (this.supportFragmentManager.findFragmentById(navHostId) as NavHostFragment).navController

fun Fragment.getNavController(): NavController =
    NavHostFragment.findNavController(this)