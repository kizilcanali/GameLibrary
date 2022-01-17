package com.alikizilcan.gamelib.data

import com.alikizilcan.gamelib.data.local.GameLocalDataSource
import com.alikizilcan.gamelib.data.local.model.GameEntity
import com.alikizilcan.gamelib.data.remote.GameDataSource
import com.alikizilcan.gamelib.data.remote.models.game.GamesResponse
import com.alikizilcan.gamelib.infra.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val gameDataSource: GameDataSource,
    private val gameLocalDataSource: GameLocalDataSource
) {
    fun listAllGame(): Flow<Resource<GamesResponse>> = flow {
        emit(gameDataSource.listAllGames())
    }.map {
        Resource.Success(it)
    }

    fun getSearchedGames(searchText: String?): Flow<List<GameEntity>> = flow {
        emit(gameLocalDataSource.getSearchedGames(searchText))
    }

    suspend fun saveGames(games: List<GameEntity>) = gameLocalDataSource.insertAllGames(games)
}