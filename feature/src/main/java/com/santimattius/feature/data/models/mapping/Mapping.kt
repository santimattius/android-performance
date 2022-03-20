package com.santimattius.feature.data.models.mapping

import com.santimattius.feature.data.models.PictureEntity
import com.santimattius.feature.domain.entities.Picture

internal fun List<Picture>.asDbEntities() = this.map { it.asDbEntity() }

internal fun Picture.asDbEntity() = PictureEntity(
    author = author,
    width = width,
    downloadUrl = downloadUrl,
    id = id,
    url = url,
    height = height
)