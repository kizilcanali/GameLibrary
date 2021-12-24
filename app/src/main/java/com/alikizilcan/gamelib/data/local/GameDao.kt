package com.alikizilcan.gamelib.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alikizilcan.gamelib.data.local.model.GameEntity


@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllGames(games:List<GameEntity>)

    @Query("UPDATE games SET favorite = :isFav WHERE id = :id")
    suspend fun setFavoriteGame(isFav: Boolean, id: Int)

    @Query("SELECT * FROM games WHERE favorite = 1")
    suspend fun getFavorites(): List<GameEntity>

    @Query("SELECT * FROM games WHERE id = :id")
    suspend fun getGameById(id: Int): GameEntity



}