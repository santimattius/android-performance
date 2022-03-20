package com.santimattius.feature.shared

import com.santimattius.feature.domain.entities.Picture

data class PictureTestModel(
    override val author: String,
    override val width: Int,
    override val downloadUrl: String,
    override val id: String,
    override val url: String,
    override val height: Int
) : Picture