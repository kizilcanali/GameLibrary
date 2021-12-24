package com.alikizilcan.gamelib.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alikizilcan.gamelib.data.local.model.GameEntity

@Database(entities = arrayOf(GameEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun gameDao(): GameDao
}