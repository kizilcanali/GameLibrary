package com.alikizilcan.gamelib.data.api.game

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("background_image") val image: String?,
    @SerializedName("rating") val rating: Double?,
)