package com.santimattius.feature.data.datasources.implementation.client

import com.santimattius.feature.core.data.Result
import com.santimattius.feature.data.models.NetworkPicture

class PicSumClient(private val service: PicSumService) {

    suspend fun fetchList(): Result<List<NetworkPicture>> = try {
        Result.success(service.fetchList())
    } catch (exception: Throwable) {
        Result.failure(ServiceError(exception.message.orEmpty()))
    }
}