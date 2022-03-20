package com.santimattius.feature.data.repositories

import com.santimattius.feature.data.datasources.LocalDataSource
import com.santimattius.feature.data.datasources.RemoteDataSource
import com.santimattius.feature.domain.entities.Picture
import com.santimattius.feature.domain.repositories.PicturesRepository

internal class PicSumRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : PicturesRepository {

    override suspend fun getPictures(): List<Picture> {
        if (localDataSource.isEmpty()) {
            val pictures = remoteDataSource.getPictures()
            localDataSource.insertPictures(pictures)
        }
        return localDataSource.getPictures()
    }

}