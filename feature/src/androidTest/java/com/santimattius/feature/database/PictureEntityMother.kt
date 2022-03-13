package com.santimattius.feature.database

import com.santimattius.feature.data.models.PictureEntity

object PictureEntityMother {

    fun create(id: Long = 1234) = PictureEntity(
        id = "$id",
        author = TestUtils.randomString(),
        width = TestUtils.randomInt(),
        height = TestUtils.randomInt(),
        url = TestUtils.randomString(),
        downloadUrl = TestUtils.randomString()
    )

    fun generate(size: Int = 10) = (1..size).map { create(id = it.toLong()) }
}
