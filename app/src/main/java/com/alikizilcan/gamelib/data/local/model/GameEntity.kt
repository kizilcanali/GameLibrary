package com.alikizilcan.gamelib.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "background_image") val image: String?,
    @ColumnInfo(name = "rating") val rating: Double?,
    val favorite: Boolean = false,
)

