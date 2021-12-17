package com.alikizilcan.gamelib.data

import com.alikizilcan.gamelib.data.api.GameDataSource
import com.alikizilcan.gamelib.data.api.detail.GameDetailResponse
import com.alikizilcan.gamelib.infra.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameDetailRepository @Inject constructor(
    private val gameDataSource: GameDataSource
){
    fun getGameById(gameId: Int): Flow<Resource<GameDetailResponse>> = flow {
        emit(gameDataSource.getGameById(gameId))
    }.map {
        Resource.Success(it)
    }
}