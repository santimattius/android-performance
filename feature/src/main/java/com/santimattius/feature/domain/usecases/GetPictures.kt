package com.santimattius.feature.domain.usecases

import com.santimattius.feature.domain.repositories.PicturesRepository

class GetPictures(private val repository: PicturesRepository) {

    suspend operator fun invoke() = repository.getPictures()
}