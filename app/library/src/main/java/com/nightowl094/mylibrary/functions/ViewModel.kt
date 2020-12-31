package com.nightowl094.mylibrary.functions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> FragmentActivity.getActivityViewModel(): T =
    ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[T::class.java]

inline fun <reified T : ViewModel> Fragment.getViewModel(): T =
    ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[T::class.java]

inline fun <reified T : ViewModel> Fragment.getActivityViewModel(): T =
    ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[T::class.java]