package com.santimattius.feature.presentation.adapters.diff

import androidx.recyclerview.widget.DiffUtil
import com.santimattius.feature.presentation.models.PictureUiModel

class PictureDiffItem : DiffUtil.ItemCallback<PictureUiModel>() {
    override fun areItemsTheSame(oldItem: PictureUiModel, newItem: PictureUiModel): Boolean {
        return oldItem.identifier == newItem.identifier
    }

    override fun areContentsTheSame(oldItem: PictureUiModel, newItem: PictureUiModel): Boolean {
        return oldItem == newItem
    }
}