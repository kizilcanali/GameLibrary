package com.alikizilcan.gamelib.data.local

import com.alikizilcan.gamelib.data.local.model.GameEntity
import javax.inject.Inject

class GameLocalDataSource @Inject constructor(private val gameDao: GameDao) {
    suspend fun insertAllGames(games: List<GameEntity>) = gameDao.insertAllGames(games)
    suspend fun setFavoriteGame(isFav: Boolean, id:Int) = gameDao.setFavoriteGame(isFav, id)
    suspend fun getFavorites() = gameDao.getFavorites()
    suspend fun getGameById(id: Int) = gameDao.getGameById(id)
}