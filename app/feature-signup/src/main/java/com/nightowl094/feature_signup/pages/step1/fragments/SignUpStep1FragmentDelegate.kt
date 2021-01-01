package com.nightowl094.feature_signup.pages.step1.fragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.nightowl094.feature_signup.R
import com.nightowl094.feature_signup.databinding.FragmentSignUpStep1Binding
import com.nightowl094.feature_signup.view_models.SignUpStep1ViewModel

class SignUpStep1FragmentDelegate(
    private val binding: FragmentSignUpStep1Binding,
    private val vm: SignUpStep1ViewModel
) {
    private val createDatePickerDialog
        get() = vm.run {
            DatePickerDialog(binding.root.context, onDateSetListener, year, month, day)
        }
    private val onDateSetListener by lazy {
        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            vm.year = year
            vm.month = month + 1
            vm.day = dayOfMonth

            updateBirthDayTextViewState(vm.year, vm.month, vm.day)
            conditionalUpdateNextPageButtonState()
        }
    }

    // ---------------------------------------------------------------------------------

    fun setUpUi() {
        setUpBirthDayCardView()
        setUpGenderCardView()
        setUpGenderManCardView()
        setUpGenderWomanCardView()
        setUpNextPageButton()
    }

    private fun setUpBirthDayCardView() {
        binding.cvBirthDay.setOnClickListener {
            createDatePickerDialog.show()
        }
    }

    private fun setUpGenderCardView() {
        binding.cvGender.setOnClickListener {
            binding.tvGender.apply {
                isSelected = true
                text = context.getString(R.string.signUpStep1_genderTextHint2)
            }
            binding.groupGender.visibility = View.VISIBLE
        }
    }

    @SuppressLint("UseCompatTextViewDrawableApis")
    private fun setUpGenderManCardView() {
        binding.cvGenderMan.setOnClickListener {
            binding.tvGenderMan.apply {
                isSelected = true
                binding.tvGenderWoman.isSelected = false
                binding.tvGender.apply {
                    isSelected = true
                    this.compoundDrawableTintList = it.context.getColorStateList(R.color.color_selector_man)
                }
                vm.gender = true

                conditionalUpdateNextPageButtonState()
            }
        }
    }

    @SuppressLint("UseCompatTextViewDrawableApis")
    private fun setUpGenderWomanCardView() {
        binding.cvGenderWoman.setOnClickListener {
            binding.tvGenderWoman.apply {
                isSelected = true
                binding.tvGenderMan.isSelected = false
                binding.tvGender.apply {
                    isSelected = true
                    this.compoundDrawableTintList = it.context.getColorStateList(R.color.color_selector_woman)
                }
                vm.gender = false

                conditionalUpdateNextPageButtonState()
            }
        }
    }

    private fun setUpNextPageButton() {
        binding.btnNextPage.setOnClickListener {
            it.findNavController().navigate(R.id.action_signUpStep1Fragment_to_signUpStep2Fragment)
        }
    }

    // ---------------------------------------------------------------------------------

    @SuppressLint("SetTextI18n")
    private fun updateBirthDayTextViewState(year: Int, month: Int, date: Int) {
        binding.tvBirthDay.apply {
            isSelected = true
            text = "${year}년 ${month}월 ${date}일"
        }
    }

    private fun conditionalUpdateNextPageButtonState() {
        if (binding.tvBirthDay.isSelected and binding.tvGender.isSelected)
            binding.clNextPageContainer.visibility = View.VISIBLE
    }

    fun startPageInitializeAnimation() {
        binding.apply {
            ivLogo.visibility = View.VISIBLE

            root.postDelayed({
                tvCaptions.visibility = View.VISIBLE
            }, 200)

            root.postDelayed({
                groupInput.visibility = View.VISIBLE
            }, 500)

            root.postDelayed({
                groupSide.visibility = View.VISIBLE
            }, 800)
        }
    }

}