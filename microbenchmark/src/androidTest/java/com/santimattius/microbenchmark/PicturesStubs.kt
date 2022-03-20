package com.santimattius.microbenchmark

import com.santimattius.feature.domain.entities.Picture
import com.santimattius.feature.presentation.models.mapping.asUiModel
import java.util.*

fun stubPictures(size: Int = 100) = (1..size).map { stubPicture("Author $it") }

fun stubPicture(author: String) = PictureBenchmarkTestModel(
    id = UUID.randomUUID().toString(),
    author = author,
    url = "https://www.pexels.com/photo/photo-of-pod-of-dolphins-2422915/",
    height = 250,
    width = 250,
    downloadUrl = "https://images.pexels.com/photos/2422915/pexels-photo-2422915.jpeg?auto=compress&cs=tinysrgb&h=350"
)

fun stubUiPicture(author: String) = stubPicture(author).asUiModel()

data class PictureBenchmarkTestModel(
    override val author: String,
    override val width: Int,
    override val downloadUrl: String,
    override val id: String,
    override val url: String,
    override val height: Int,
) : Picture