package com.nightowl094.feature_signup.pages.step3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.nightowl094.domain.use_case.CheckValidationToEmailUseCase
import com.nightowl094.domain.use_case.SignUpUseCase
import com.nightowl094.feature_signup.databinding.FragmentSignUpStep3Binding
import com.nightowl094.feature_signup.view_models.SignUpActivityViewModel
import com.nightowl094.mylibrary.functions.getActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUpStep3Fragment : Fragment() {

    private val vm by lazy {
        getActivityViewModel<SignUpActivityViewModel>()
    }
    private val delegate by lazy { SignUpStep3FragmentDelegate(binding, vm) }
    private lateinit var binding: FragmentSignUpStep3Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentSignUpStep3Binding.inflate(layoutInflater).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        delegate.setUpUi()
        initObservers()
    }

    private fun initObservers() {
        vm.checkValidationToEmailResponse.observe(viewLifecycleOwner, {
            if (it.success.not()) {
                delegate.showEmailContainerError(true, it.msg)
            }
        })

        vm.requestSignUpResponse.observe(viewLifecycleOwner, {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("회원 가입 성공 알림")
                .setMessage("$it")
                .show()
        })
    }

}