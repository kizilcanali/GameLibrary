package com.alikizilcan.gamelib.domain.mapper

import com.alikizilcan.gamelib.data.local.model.GameEntity
import com.alikizilcan.gamelib.data.remote.models.game.GamesResponse
import javax.inject.Inject

class GameEntityMapper @Inject constructor() {


    fun mapFromGameResponse(response: GamesResponse) : List<GameEntity> =
        response.results.map {
            GameEntity(
                id = it.id,
                name = it.name,
                image = it.image,
                rating = it.rating
            )
        }
}