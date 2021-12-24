package com.alikizilcan.gamelib.data.remote.models.detail

import com.google.gson.annotations.SerializedName

data class GameDetailResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("metacritic") val metacritic: Int,
    @SerializedName("rating") val rating: Double,
    @SerializedName("genres") val genres: List<GenreResponse>,
    @SerializedName("released") val releaseDate: String,
    @SerializedName("description_raw") val description: String,
    @SerializedName("background_image") val image: String
)