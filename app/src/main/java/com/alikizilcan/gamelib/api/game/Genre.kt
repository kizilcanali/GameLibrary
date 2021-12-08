package com.alikizilcan.gamelib.api.game

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("name") val genreName: String,
)
