package com.nightowl094.feature_signup.view_models

import androidx.lifecycle.ViewModel
import com.nightowl094.mylibrary.annotations.UiState
import com.nightowl094.mylibrary.regex.RegexConst

class SignUpStep3ViewModel : ViewModel() {

    @UiState
    var email: String = ""

    @UiState
    var password: String = ""

    @UiState
    var passwordConfirm: String = ""

    // ---------------------------------------------------------------------------------

    val isValidEmail
        get() = RegexConst.checkEmailValid(email)

    val isValidPassword
        get() = RegexConst.checkPwRegex(password)

    val isMatchedPassword
        get() = password == passwordConfirm

    val isEnabledButton
        get() = isValidEmail and isValidPassword and isMatchedPassword
}