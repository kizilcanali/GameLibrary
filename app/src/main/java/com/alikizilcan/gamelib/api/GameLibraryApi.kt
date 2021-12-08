package com.alikizilcan.gamelib.api


import com.alikizilcan.gamelib.api.game.GameResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GameLibraryApi{

    @GET("games?key=85bd3033067541978d52f0e63e888a5d")
    suspend fun listAllGames() : Response<List<GameResponse>>

    @GET("games/{id}?key=85bd3033067541978d52f0e63e888a5d")
    suspend fun getGameById(@Path("id") id: Int) : Response<GameResponse>

}