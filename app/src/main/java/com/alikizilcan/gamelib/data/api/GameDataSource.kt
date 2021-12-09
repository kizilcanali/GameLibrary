package com.alikizilcan.gamelib.data.api

import com.alikizilcan.gamelib.data.api.game.GamesResponse
import javax.inject.Inject

class GameDataSource  @Inject constructor(private val gameLibraryApiService: GameLibraryApi){
    suspend fun listAllGames() : GamesResponse = gameLibraryApiService.listAllGames()
    //TODO: fetch detail
}