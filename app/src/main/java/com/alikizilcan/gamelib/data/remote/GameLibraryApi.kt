package com.alikizilcan.gamelib.data.remote


import com.alikizilcan.gamelib.infra.API_KEY
import com.alikizilcan.gamelib.data.remote.models.detail.GameDetailResponse
import com.alikizilcan.gamelib.data.remote.models.game.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameLibraryApi{

    @GET("games")
    suspend fun listAllGames(
        @Query("key") key: String = API_KEY
    ) : GamesResponse

    @GET("games/{id}")
    suspend fun getGameById(
        @Path("id") id: Int,
        @Query("key") key: String = API_KEY
    ) : GameDetailResponse
}
