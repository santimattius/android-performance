package com.santimattius.microbenchmark

import com.santimattius.feature.domain.entities.Picture
import com.santimattius.feature.domain.repositories.PicturesRepository

class FakePicturesRepository : PicturesRepository {
    override suspend fun getPictures(): List<Picture> {
        return stubPictures()
    }
}