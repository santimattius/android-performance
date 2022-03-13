package com.santimattius.feature.data.datasources.implementation.client

import com.santimattius.feature.core.data.AppException

data class ServiceError(val error: String) : AppException(error)
