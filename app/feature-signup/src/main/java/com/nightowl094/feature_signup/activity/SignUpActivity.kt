package com.nightowl094.feature_signup.activity

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.nightowl094.feature_signup.R
import com.nightowl094.feature_signup.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    val progressAnimationEnd by lazy { MutableLiveData<Boolean>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpProgressbar()
    }

    private fun setUpProgressbar() {
        binding.progressBar2.apply {
            ObjectAnimator.ofInt(this, "progress", 0, 30).apply {
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

}