package com.alikizilcan.gamelib.api


import com.alikizilcan.gamelib.tools.API_KEY
import com.alikizilcan.gamelib.api.detail.GameDetailResponse
import com.alikizilcan.gamelib.api.game.GameResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameLibraryApi{

    @GET("/games")
    suspend fun listAllGames(
        @Query("key") key: String = API_KEY
    ) : Response<List<GameResponse>>

    @GET("games/{id}")
    suspend fun getGameById(
        @Path("id") id: Int,
        @Query("key") key: String = API_KEY
    ) : Response<GameDetailResponse>
}
