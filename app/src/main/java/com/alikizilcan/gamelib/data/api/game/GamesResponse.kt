package com.alikizilcan.gamelib.data.api.game

import com.google.gson.annotations.SerializedName


data class GamesResponse(
    @SerializedName("results") val results: List<GameResponse>
)