package com.alikizilcan.gamelib.data.remote

import com.alikizilcan.gamelib.data.remote.models.detail.GameDetailResponse
import com.alikizilcan.gamelib.data.remote.models.game.GamesResponse
import javax.inject.Inject

class GameDataSource  @Inject constructor(private val gameLibraryApiService: GameLibraryApi){
    suspend fun listAllGames() : GamesResponse = gameLibraryApiService.listAllGames()
    suspend fun getGameById(gameId: Int) : GameDetailResponse = gameLibraryApiService.getGameById(gameId)
}