package com.santimattius.feature.data.datasources

import com.santimattius.feature.domain.entities.Picture

interface RemoteDataSource {

    suspend fun getPictures(): List<Picture>
}