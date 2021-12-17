package com.alikizilcan.gamelib.domain.model

import com.alikizilcan.gamelib.data.api.detail.GenreResponse

data class GameDetail (
    val id: Int,
    val name: String,
    val metacritic: String,
    val rating: String,
    val genres: String,
    val releaseDate: String,
    val description: String,
    val image: String
)