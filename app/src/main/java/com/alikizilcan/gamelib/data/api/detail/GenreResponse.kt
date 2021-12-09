package com.alikizilcan.gamelib.data.api.detail

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("name") val genreName: String,
)
