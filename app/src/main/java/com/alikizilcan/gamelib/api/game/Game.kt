package com.alikizilcan.gamelib.api.game

data class Game(
    val id: Int,
    val name: String,
    val metacritic: Int,
    val releaseDate: String,
    val image: String,
    val platforms: List<Platform>,
    val genres: List<Genre>
)