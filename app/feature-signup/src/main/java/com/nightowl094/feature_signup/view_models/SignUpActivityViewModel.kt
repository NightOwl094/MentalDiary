package com.nightowl094.feature_signup.view_models

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nightowl094.domain.constants.DateFormat
import com.nightowl094.domain.constants.GenderTypes
import com.nightowl094.domain.entities.SimpleResponse
import com.nightowl094.domain.entities.User
import com.nightowl094.domain.use_case.CheckValidationToEmailUseCase
import com.nightowl094.domain.use_case.SignUpUseCase
import com.nightowl094.mylibrary.annotations.UiState
import com.nightowl094.mylibrary.regex.RegexConst
import com.nightowl094.mylibrary.util_class.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class SignUpActivityViewModel : ViewModel() {
    lateinit var checkValidationToEmailUseCase: CheckValidationToEmailUseCase
    lateinit var signUpUseCase: SignUpUseCase

    // ---------------------------------------------------------------------------------

    @UiState
    var year: Int = Calendar.getInstance().get(Calendar.YEAR)

    @UiState
    var month: Int = Calendar.getInstance().get(Calendar.MONTH)

    @UiState
    var day: Int = Calendar.getInstance().get(Calendar.DATE)

    @UiState
    var gender: Int = GenderTypes.MAN.ordinal

    @UiState
    var email: String = ""

    @UiState
    var password: String = ""

    @UiState
    var passwordConfirm: String = ""

    // ---------------------------------------------------------------------------------

    val birthDay: String
        get() = SimpleDateFormat(DateFormat.DATE_FORMAT, Locale.KOREA).format(
            Calendar.getInstance().apply {
                set(year, month - 1, day)
            }.time
        )

    val isValidEmail
        get() = RegexConst.checkEmailValid(email)

    val isValidPassword
        get() = RegexConst.checkPwRegex(password)

    val isMatchedPassword
        get() = password == passwordConfirm

    val isEnabledButton
        get() = isValidEmail and isValidPassword and isMatchedPassword and isUniqueEmail

    private val isUniqueEmail
        get() = checkValidationToEmailResponse.value?.success ?: false

    val createUser
        get() = User(id = null, email, password, gender, birthDay)

    // ---------------------------------------------------------------------------------

    val checkValidationToEmailResponse by lazy { SingleLiveEvent<SimpleResponse>() }

    fun checkValidationToEmail(email: String) =
        viewModelScope.launch(Dispatchers.IO) {
            checkValidationToEmailResponse.postValue(checkValidationToEmailUseCase.checkValidationToEmail(email))
        }

    val requestSignUpResponse by lazy { SingleLiveEvent<SimpleResponse>() }

    fun requestSignUp(user: User) =
        viewModelScope.launch(Dispatchers.IO) {
            requestSignUpResponse.postValue(signUpUseCase.requestSignUp(user))
        }

}