package com.nightowl094.feature_signup.pages.step3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nightowl094.feature_signup.databinding.FragmentSignUpStep3Binding
import com.nightowl094.feature_signup.view_models.SignUpStep3ViewModel
import com.nightowl094.mylibrary.functions.getActivityViewModel

class SignUpStep3Fragment : Fragment() {

    private val vm by lazy { getActivityViewModel<SignUpStep3ViewModel>() }
    private val delegate by lazy { SignUpStep3FragmentDelegate(binding, vm) }
    private lateinit var binding: FragmentSignUpStep3Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentSignUpStep3Binding.inflate(layoutInflater).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        delegate.setUpUi()
    }

}