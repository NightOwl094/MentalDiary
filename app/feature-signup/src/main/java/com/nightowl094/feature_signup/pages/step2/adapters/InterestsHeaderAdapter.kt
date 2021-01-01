package com.nightowl094.feature_signup.pages.step2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nightowl094.feature_signup.databinding.ItemInterestsHeaderBinding
import com.nightowl094.mylibrary.view_holder.CustomViewHolder

class InterestsHeaderAdapter : RecyclerView.Adapter<CustomViewHolder<ItemInterestsHeaderBinding>>() {

    private val layoutParams = StaggeredGridLayoutManager.LayoutParams(
        StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT,
        StaggeredGridLayoutManager.LayoutParams.WRAP_CONTENT
    ).apply {
        isFullSpan = true
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemInterestsHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false).let { binding ->
            CustomViewHolder(binding, binding.root)
        }

    override fun getItemCount() = 1
    override fun onBindViewHolder(holder: CustomViewHolder<ItemInterestsHeaderBinding>, position: Int) {
        holder.binding.root.layoutParams = layoutParams
    }

}