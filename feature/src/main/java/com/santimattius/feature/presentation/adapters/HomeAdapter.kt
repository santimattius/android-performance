package com.santimattius.feature.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.santimattius.feature.presentation.adapters.diff.PictureDiffItem
import com.santimattius.feature.presentation.adapters.viewholders.PictureViewHolder
import com.santimattius.feature.presentation.models.PictureUiModel

class HomeAdapter(private val onItemClick: (PictureUiModel) -> Unit = {}) :
    ListAdapter<PictureUiModel, PictureViewHolder>(PictureDiffItem()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }
}



