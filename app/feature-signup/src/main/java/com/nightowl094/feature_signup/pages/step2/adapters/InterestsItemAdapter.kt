package com.nightowl094.feature_signup.pages.step2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nightowl094.feature_signup.databinding.ItemInterestsBinding
import com.nightowl094.mylibrary.functions.loadUrl
import com.nightowl094.mylibrary.view_holder.CustomViewHolder

class InterestsItemAdapter(
    private val itemTouchCallback: (Boolean) -> Unit
) : RecyclerView.Adapter<CustomViewHolder<ItemInterestsBinding>>() {
    private val dataList =
        listOf(
            "https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/03/30/12/37/jellyfish-698521_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/01/14/13/59/castelmezzano-1979546_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/11/04/20/59/milky-way-1023340_1280.jpg",
            "https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/03/30/12/37/jellyfish-698521_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/01/14/13/59/castelmezzano-1979546_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/11/04/20/59/milky-way-1023340_1280.jpg",
            "https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/03/30/12/37/jellyfish-698521_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/01/14/13/59/castelmezzano-1979546_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/11/04/20/59/milky-way-1023340_1280.jpg",
            "https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/03/30/12/37/jellyfish-698521_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/01/14/13/59/castelmezzano-1979546_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/11/04/20/59/milky-way-1023340_1280.jpg"
        ) // todo mock data

    private val stateMap by lazy { mutableMapOf<Int, Boolean>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemInterestsBinding.inflate(LayoutInflater.from(parent.context), parent, false).let { binding ->
            CustomViewHolder(binding, binding.root).also { vh ->
                vh.binding.apply {

                    cvInterests.setOnClickListener {
                        updateStateMap(vh.adapterPosition)
                        tvTitle.isSelected = stateMap[vh.adapterPosition] ?: false

                        itemTouchCallback(stateMap.isNotEmpty())
                    }

                }
            }
        }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder<ItemInterestsBinding>, position: Int) {
        bindTo(holder.binding, dataList[position], position)
    }

    private fun bindTo(binding: ItemInterestsBinding, imageUrl: String, position: Int) {
        binding.apply {
            ivThumb.loadUrl(imageUrl)
            tvTitle.isSelected = stateMap[position] ?: false
        }
    }

    // ---------------------------------------------------------------------------------
    private fun updateStateMap(position: Int) {
        stateMap[position]?.run {
            stateMap.remove(position)
        } ?: run {
            stateMap[position] = true
        }
    }

}