package com.alikizilcan.gamelib.domain

import com.alikizilcan.gamelib.data.FavoriteRepository
import com.alikizilcan.gamelib.domain.mapper.GameEntityToGameMapper
import com.alikizilcan.gamelib.domain.model.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository,
    private val gameEntityToGameMapper: GameEntityToGameMapper
) {

    fun getFavorites(): Flow<List<Game>> {
        return favoriteRepository.getFavorites().map {
            it.map { entity ->
                gameEntityToGameMapper.mapFromGameEntity(entity)
            }
        }
    }
}