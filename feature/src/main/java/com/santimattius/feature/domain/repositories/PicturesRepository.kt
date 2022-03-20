package com.santimattius.feature.domain.repositories

import com.santimattius.feature.domain.entities.Picture

interface PicturesRepository {

    suspend fun getPictures(): List<Picture>
}