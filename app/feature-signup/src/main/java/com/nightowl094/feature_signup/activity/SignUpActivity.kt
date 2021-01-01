package com.nightowl094.feature_signup.activity

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.nightowl094.feature_signup.R
import com.nightowl094.feature_signup.databinding.ActivitySignUpBinding
import com.nightowl094.mylibrary.functions.getNavController

class SignUpActivity : AppCompatActivity() {

    private val nc by lazy { getNavController(binding.fragmentContainerView.id) }
    private lateinit var binding: ActivitySignUpBinding
    val progressAnimationEnd by lazy { MutableLiveData<Boolean>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigationChangeListener()
    }

    private fun setUpNavigationChangeListener() {
        nc.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.signUpStep1Fragment ->
                    setUpProgressbar()
                R.id.signUpStep2Fragment ->
                    updateProgressbarState(60)
                R.id.signUpStep3Fragment ->
                    updateProgressbarState(95)
            }
        }
    }

    private fun setUpProgressbar() {
        binding.progressBar2.apply {
            ObjectAnimator.ofInt(this, "progress", binding.progressBar2.progress, 30).apply {
                duration = 1000
                interpolator = AccelerateDecelerateInterpolator()
                addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator?) {}
                    override fun onAnimationCancel(animation: Animator?) {}
                    override fun onAnimationRepeat(animation: Animator?) {}
                    override fun onAnimationEnd(animation: Animator?) {
                        progressAnimationEnd.value = true
                    }
                })
            }.start()
        }
    }

    private fun updateProgressbarState(progress: Int) {
        binding.progressBar2.apply {
            ObjectAnimator.ofInt(this, "progress", binding.progressBar2.progress, progress).apply {
                duration = 1000
                interpolator = AccelerateDecelerateInterpolator()
            }.start()
        }

    }

}