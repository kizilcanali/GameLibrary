package com.alikizilcan.gamelib.domain.mapper

import com.alikizilcan.gamelib.data.remote.models.detail.GameDetailResponse
import com.alikizilcan.gamelib.domain.model.GameDetail
import com.alikizilcan.gamelib.infra.mergeTexts
import com.alikizilcan.gamelib.infra.orZero
import javax.inject.Inject

class GameDetailMapper @Inject constructor() {
    fun mapFromGameDetailResponse(response: GameDetailResponse) : GameDetail =
        GameDetail(
            id = response.id.orZero(),
            name = response.name.orEmpty(),
            metacritic = response.metacritic.toString().orEmpty(),
            rating = response.rating.toString().orEmpty(),
            genres = response.genres.mergeTexts(response.genres),
            releaseDate = response.releaseDate.orEmpty(),
            description = response.description.orEmpty(),
            image = response.image.orEmpty()
        )
}