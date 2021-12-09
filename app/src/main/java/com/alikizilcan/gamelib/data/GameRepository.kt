package com.alikizilcan.gamelib.data

import com.alikizilcan.gamelib.data.api.GameDataSource
import com.alikizilcan.gamelib.data.api.game.GamesResponse
import com.alikizilcan.gamelib.infra.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val gameDataSource: GameDataSource
){
    fun listAllGame(): Flow<Resource<GamesResponse>> = flow {
        emit(gameDataSource.listAllGames())
    }.map {
        Resource.Success(it)
    }
}