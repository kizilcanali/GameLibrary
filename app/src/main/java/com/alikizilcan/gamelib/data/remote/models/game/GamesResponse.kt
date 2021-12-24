package com.alikizilcan.gamelib.data.remote.models.game

import com.google.gson.annotations.SerializedName


data class GamesResponse(
    @SerializedName("results") val results: List<GameResponse>
)