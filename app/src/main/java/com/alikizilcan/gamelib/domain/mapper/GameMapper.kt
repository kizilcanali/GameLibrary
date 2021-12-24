package com.alikizilcan.gamelib.domain.mapper

import com.alikizilcan.gamelib.data.remote.models.game.GameResponse
import com.alikizilcan.gamelib.data.remote.models.game.GamesResponse
import com.alikizilcan.gamelib.domain.model.Game
import com.alikizilcan.gamelib.infra.orZero
import javax.inject.Inject

class GameMapper @Inject constructor(){

    fun mapFromGameResponse(response : GamesResponse) : List<Game> =
        response.results.map { game ->
            Game(
                id = game.id.orZero(),
                name = game.name.orEmpty(),
                image = game.image.orEmpty(),
                rating = game.rating.toString().orEmpty(),
                favorite = false
            )
        }
}

