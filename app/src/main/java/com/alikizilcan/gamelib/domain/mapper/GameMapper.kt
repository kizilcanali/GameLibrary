package com.alikizilcan.gamelib.domain.mapper

import com.alikizilcan.gamelib.data.api.game.GameResponse
import com.alikizilcan.gamelib.data.api.game.GamesResponse
import com.alikizilcan.gamelib.domain.model.Game
import com.alikizilcan.gamelib.domain.model.Games
import com.alikizilcan.gamelib.infra.orZero
import javax.inject.Inject

class GameMapper @Inject constructor(){

    fun mapFromGamesResponse(response : GamesResponse) : Games =
        Games(
            results = mapFromGameResponse(response.results)
        )

    private fun mapFromGameResponse(response : List<GameResponse>) : List<Game> =
        response.map {
            Game(
                id = it.id.orZero(),
                name = it.name.orEmpty(),
                image = it.image.orEmpty(),
                rating = it.rating.orZero()
            )
        }
}

