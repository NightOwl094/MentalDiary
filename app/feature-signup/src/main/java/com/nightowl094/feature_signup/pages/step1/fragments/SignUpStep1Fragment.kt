package com.nightowl094.feature_signup.pages.step1.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nightowl094.domain.use_case.CheckValidationToEmailUseCase
import com.nightowl094.feature_signup.activity.SignUpActivity
import com.nightowl094.feature_signup.databinding.FragmentSignUpStep1Binding
import com.nightowl094.feature_signup.view_models.SignUpActivityViewModel
import com.nightowl094.mylibrary.functions.getActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUpStep1Fragment : Fragment() {
    private val act by lazy { activity as? SignUpActivity }
    private val delegate by lazy { SignUpStep1FragmentDelegate(binding!!, vm) }
    private val vm by lazy { getActivityViewModel<SignUpActivityViewModel>() }

    private var binding: FragmentSignUpStep1Binding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return createBinding()
    }

    private fun createBinding() =
        binding?.run {
            this.root
        } ?: run {
            FragmentSignUpStep1Binding.inflate(layoutInflater).apply {
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