package com.alikizilcan.gamelib.domain.model

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