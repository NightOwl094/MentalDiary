package com.nightowl094.feature_signup.pages.step2.fragments

import android.graphics.Rect
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nightowl094.feature_signup.R
import com.nightowl094.feature_signup.databinding.FragmentSignUpStep2Binding
import com.nightowl094.feature_signup.pages.step2.adapters.InterestsHeaderAdapter
import com.nightowl094.feature_signup.pages.step2.adapters.InterestsItemAdapter
import com.nightowl094.mylibrary.functions.convertPx

class SignUpStep2FragmentDelegate(
    private val binding: FragmentSignUpStep2Binding
) {
    var isInit = false

    fun setUpUi() {
        setUpRecyclerView()
        setUpNextPageButton()
    }

    private fun setUpRecyclerView() {
        binding.rcvInterests.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
            }

            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                    super.getItemOffsets(outRect, view, parent, state)

                    val pos = parent.getChildAdapterPosition(view)
                    val spanIndex = (view.layoutParams as StaggeredGridLayoutManager.LayoutParams).spanIndex

                    if (spanIndex == 0) {
                        outRect.right = convertPx(8)
                    }

                    if (pos > 2) {
                        outRect.top = convertPx(8)
                    }

                }
            })

        }
    }

    private fun setUpNextPageButton() {
        binding.btnNextPage.setOnClickListener {
            it.findNavController().navigate(R.id.action_signUpStep2Fragment_to_signUpStep3Fragment)
        }
    }

    fun initRecyclerViewAdapter() {
        binding.rcvInterests.apply {
            adapter = ConcatAdapter(InterestsHeaderAdapter(), InterestsItemAdapter(::updateNextPageButtonVisibility))
        }
    }

    // ---------------------------------------------------------------------------------

    private fun updateNextPageButtonVisibility(isEnable: Boolean) {
        if (isEnable)
            binding.clNextPageContainer.visibility = View.VISIBLE
        else
            binding.clNextPageContainer.visibility = View.GONE
    }
}