package com.santimattius.feature.objectmothers

import com.santimattius.feature.data.models.NetworkPicture

object NetworkPictureMother {

    fun pictures() = (1..10).map { NetworkPicture(id = it.toString()) }
}