package com.santimattius.feature.data.datasources.implementation

import com.santimattius.feature.core.data.Failure
import com.santimattius.feature.core.data.Success
import com.santimattius.feature.data.datasources.RemoteDataSource
import com.santimattius.feature.data.datasources.implementation.client.PicSumClient

internal class ServiceDataSource(private val client: PicSumClient) : RemoteDataSource {

    override suspend fun getPictures() = when (val result = client.fetchList()) {
        is Success -> result.out
        is Failure -> emptyList()
    }

}