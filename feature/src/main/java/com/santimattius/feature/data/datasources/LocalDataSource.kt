package com.santimattius.feature.data.datasources

import com.santimattius.feature.domain.entities.Picture

interface LocalDataSource {

    suspend fun isEmpty(): Boolean

    suspend fun getPictures(): List<Picture>

    suspend fun insertPictures(pictures: List<Picture>)
}