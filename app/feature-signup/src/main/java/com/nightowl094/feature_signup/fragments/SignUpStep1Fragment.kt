package com.nightowl094.feature_signup.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nightowl094.feature_signup.activity.SignUpActivity
import com.nightowl094.feature_signup.databinding.FragmentSignUpStep1Binding
import com.nightowl094.feature_signup.view_models.SignUpStep1ViewModel
import com.nightowl094.mylibrary.functions.getActivityViewModel

class SignUpStep1Fragment : Fragment() {

    private val act by lazy { activity as? SignUpActivity }
    private val delegate by lazy { SignUpStep1FragmentDelegate(binding, vm) }
    private val vm by lazy { getActivityViewModel<SignUpStep1ViewModel>() }
    private lateinit var binding: FragmentSignUpStep1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentSignUpStep1Binding.inflate(layoutInflater).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        delegate.setUpUi()

        act?.progressAnimationEnd?.observe(viewLifecycleOwner, {
            delegate.startPageInitializeAnimation()
        })

    }

}