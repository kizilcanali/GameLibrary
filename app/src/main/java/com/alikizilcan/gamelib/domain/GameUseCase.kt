package com.alikizilcan.gamelib.domain

import com.alikizilcan.gamelib.data.GameRepository
import com.alikizilcan.gamelib.data.remote.models.game.GamesResponse
import com.alikizilcan.gamelib.domain.mapper.GameEntityMapper
import com.alikizilcan.gamelib.domain.mapper.GameEntityToGameMapper
import com.alikizilcan.gamelib.domain.mapper.GameMapper
import com.alikizilcan.gamelib.domain.model.Game
import com.alikizilcan.gamelib.infra.Resource
import com.alikizilcan.gamelib.infra.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GameUseCase @Inject constructor(
    private val gameMapper: GameMapper,
    private val repository: GameRepository,
    private val gameEntityMapper: GameEntityMapper,
) {

    fun listAllGames(): Flow<Resource<List<Game>>> {
        return repository.listAllGame()
            .map { resource ->
                resource.map {
                    saveGames(it)
                    gameMapper.mapFromGameResponse(it)
                }
            }
            .onStart { emit(Resource.Loading) }
            .catch { emit(Resource.Error(it)) }
    }

    private suspend fun saveGames(games: GamesResponse){
        repository.saveGames(gameEntityMapper.mapFromGameResponse(games))
    }

}