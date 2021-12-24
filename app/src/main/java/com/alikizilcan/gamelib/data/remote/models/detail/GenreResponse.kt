package com.alikizilcan.gamelib.data.remote.models.detail

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("name") val genreName: String,
)
