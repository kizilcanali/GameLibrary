package com.alikizilcan.gamelib.domain

import com.alikizilcan.gamelib.data.GameRepository
import com.alikizilcan.gamelib.domain.mapper.GameMapper
import com.alikizilcan.gamelib.domain.model.Game
import com.alikizilcan.gamelib.domain.model.Games
import com.alikizilcan.gamelib.infra.Resource
import com.alikizilcan.gamelib.infra.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GameUseCase @Inject constructor(
    private val gameMapper: GameMapper,
    private val repository: GameRepository
) {

    fun listAllGames(): Flow<Resource<Games>>{
        return repository.listAllGame()
            .map {
                it.map { response ->
                    gameMapper.mapFromGamesResponse(response)
                }
            }
            .onStart { emit(Resource.Loading) }
            .catch { emit(Resource.Error(it)) }
    }

}