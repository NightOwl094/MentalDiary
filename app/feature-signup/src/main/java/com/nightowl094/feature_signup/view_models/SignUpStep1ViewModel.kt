package com.nightowl094.feature_signup.view_models

import androidx.lifecycle.ViewModel
import com.nightowl094.mylibrary.annotations.UiState
import java.util.*

class SignUpStep1ViewModel : ViewModel() {

    @UiState
    var year: Int = Calendar.getInstance().get(Calendar.YEAR)

    @UiState
    var month: Int = Calendar.getInstance().get(Calendar.MONTH)

    @UiState
    var day: Int = Calendar.getInstance().get(Calendar.DATE)

    @UiState
    var gender: Boolean = false

}