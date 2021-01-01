package com.nightowl094.feature_signup.pages.step2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nightowl094.feature_signup.databinding.FragmentSignUpStep2Binding

class SignUpStep2Fragment : Fragment() {

    private val delegate by lazy { SignUpStep2FragmentDelegate(binding) }
    private lateinit var binding: FragmentSignUpStep2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentSignUpStep2Binding.inflate(layoutInflater).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        delegate.setUpUi()

        delegate.initRecyclerViewAdapter()
    }

}