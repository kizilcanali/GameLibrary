package com.alikizilcan.gamelib.data

import com.alikizilcan.gamelib.data.local.GameLocalDataSource
import com.alikizilcan.gamelib.data.local.model.GameEntity
import com.alikizilcan.gamelib.data.remote.GameDataSource
import com.alikizilcan.gamelib.data.remote.models.detail.GameDetailResponse
import com.alikizilcan.gamelib.infra.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameDetailRepository @Inject constructor(
    private val gameDataSource: GameDataSource,
    private val gameLocalDataSource: GameLocalDataSource
) {

    suspend fun setFavoriteGame(isFav: Boolean, id: Int) =
        gameLocalDataSource.setFavoriteGame(isFav, id)

    fun getGameById(gameId: Int): Flow<Resource<GameDetailResponse>> = flow {
        emit(gameDataSource.getGameById(gameId))
    }.map {
        Resource.Success(it)
    }

    fun getGameByIdFromLocal(id: Int): Flow<GameEntity> = flow {
        emit(gameLocalDataSource.getGameById(id))
    }
}