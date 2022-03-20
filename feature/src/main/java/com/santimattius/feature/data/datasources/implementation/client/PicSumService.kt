package com.santimattius.feature.data.datasources.implementation.client

import com.santimattius.feature.data.models.NetworkPicture
import retrofit2.http.GET

interface PicSumService {

    @GET("/pictures")
    suspend fun fetchList(): List<NetworkPicture>
}