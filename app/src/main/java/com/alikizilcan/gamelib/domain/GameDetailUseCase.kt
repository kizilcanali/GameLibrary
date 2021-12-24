package com.alikizilcan.gamelib.domain

import com.alikizilcan.gamelib.data.GameDetailRepository
import com.alikizilcan.gamelib.domain.mapper.GameDetailMapper
import com.alikizilcan.gamelib.domain.mapper.GameEntityToGameMapper
import com.alikizilcan.gamelib.domain.model.Game
import com.alikizilcan.gamelib.domain.model.GameDetail
import com.alikizilcan.gamelib.infra.Resource
import com.alikizilcan.gamelib.infra.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GameDetailUseCase @Inject constructor(
    private val gameDetailMapper: GameDetailMapper,
    private val repository: GameDetailRepository,
    private val gameEntityToGameMapper: GameEntityToGameMapper
) {
    fun getGameById(gameId: Int) : Flow<Resource<GameDetail>>{
        return repository.getGameById(gameId)
            .map {
                it.map { response ->
                    gameDetailMapper.mapFromGameDetailResponse(response)
                }
            }
            .onStart { emit(Resource.Loading) }
            .catch { emit(Resource.Error(it)) }
    }

    fun getGameByIdFromLocal(gameId: Int) : Flow<Game> =
        repository.getGameByIdFromLocal(gameId).map {
            gameEntityToGameMapper.mapFromGameEntity(it)
        }
    suspend fun updateFavorite(isFav: Boolean, id: Int){
        repository.setFavoriteGame(isFav,id)
    }

}