package com.alikizilcan.gamelib.domain.mapper

import com.alikizilcan.gamelib.data.local.model.GameEntity
import com.alikizilcan.gamelib.domain.model.Game
import com.alikizilcan.gamelib.infra.orZero
import javax.inject.Inject

class GameEntityToGameMapper @Inject constructor() {
    fun mapFromGameEntity(entity: GameEntity): Game {
        return Game(
            id = entity.id.orZero(),
            name = entity.name.orEmpty(),
            image = entity.image.orEmpty(),
            rating = entity.rating.toString().orEmpty(),
            genres = " ",
            favorite = entity.favorite,
        )
    }
}