package com.alikizilcan.gamelib.data

import com.alikizilcan.gamelib.data.local.GameLocalDataSource
import com.alikizilcan.gamelib.data.local.model.GameEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val gameLocalDataSource: GameLocalDataSource) {

    fun getFavorites(): Flow<List<GameEntity>> = flow {
        emit(
            gameLocalDataSource.getFavorites()
        )
    }
}