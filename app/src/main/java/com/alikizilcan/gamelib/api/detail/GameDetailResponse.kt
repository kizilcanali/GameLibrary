package com.alikizilcan.gamelib.api.detail

import com.alikizilcan.gamelib.api.game.Genre
import com.google.gson.annotations.SerializedName

data class GameDetailResponse (
    val id: Int,
    val name: String,
    val metacritic: Int,
    val rating: Double,
    val genres: List<Genre>,
    @SerializedName("released") val releaseDate: String,
    @SerializedName("description_raw") val description: String,
    @SerializedName("background_image") val image: String
)