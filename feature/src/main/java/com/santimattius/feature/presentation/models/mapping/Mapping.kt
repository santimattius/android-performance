package com.santimattius.feature.presentation.models.mapping

import com.santimattius.feature.domain.entities.Picture
import com.santimattius.feature.presentation.models.PictureUiModel


fun List<Picture>.asUiModels() = map { it.asUiModel() }

fun Picture.asUiModel() =
    PictureUiModel(
        id = id,
        author = author,
        imageUrl = downloadUrl,
        height = height,
        width = width,
        link = url
    )