package com.alikizilcan.gamelib.api.game

import com.google.gson.annotations.SerializedName

data class GameResponse(
    val id: Int,
    val name: String,
    @SerializedName("background_image") val image: String,
    val rating: Double,
)