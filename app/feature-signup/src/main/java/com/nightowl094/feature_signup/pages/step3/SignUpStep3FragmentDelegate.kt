package com.nightowl094.feature_signup.pages.step3

import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.nightowl094.feature_signup.R
import com.nightowl094.feature_signup.databinding.FragmentSignUpStep3Binding
import com.nightowl094.feature_signup.view_models.SignUpStep3ViewModel

class SignUpStep3FragmentDelegate(
    private val binding: FragmentSignUpStep3Binding,
    private val vm: SignUpStep3ViewModel
) {

    fun setUpUi() {
        setUpEmailEditText()
        setUpPasswordEditText()
        setUpPasswordConfirmEditText()
        setUpStartButton()
    }

    private fun setUpEmailEditText() {
        binding.etEmail.addTextChangedListener {
            vm.email = it.toString()

            if (vm.isValidEmail.not()) {
                binding.tilEmail.apply {
                    error = context.getString(R.string.signUpStep3_isNotValidEmail)
                    isSelected = false
                }
            } else {
                binding.tilEmail.apply {
                    isErrorEnabled = false
                    isSelected = true
                }
            }

            updateStartButtonState(vm.isEnabledButton)
        }
    }

    private fun setUpPasswordEditText() {
        binding.etPw.addTextChangedListener {
            vm.password = it.toString()

            if (vm.isValidPassword.not()) {
                binding.tilPw.apply {
                    error = context.getString(R.string.signUpStep3_isNotValidPassword)
                    isSelected = false
                }
            } else {
                binding.tilPw.apply {
                    isErrorEnabled = false
                    isSelected = true
                }
            }

            updateStartButtonState(vm.isEnabledButton)
        }
    }

    private fun setUpPasswordConfirmEditText() {
        binding.etPwConfirm.addTextChangedListener {
            vm.passwordConfirm = it.toString()

            if (vm.isMatchedPassword.not()) {
                binding.tilPwConfirm.apply {
                    error = context.getString(R.string.signUpStep3_isNotMatchedPassword)
                    isSelected = false
                }
            } else {
                binding.tilPwConfirm.apply {
                    isErrorEnabled = false
                    isSelected = true
                }
            }

            updateStartButtonState(vm.isEnabledButton)
        }
    }

    private fun setUpStartButton() {
        binding.startButton.setOnClickListener {
            Toast.makeText(it.context, "started", Toast.LENGTH_SHORT).show()
        }
    }

    // ---------------------------------------------------------------------------------

    private fun updateStartButtonState(isEnable: Boolean) {
        binding.startButton.isEnabled = isEnable
    }

}