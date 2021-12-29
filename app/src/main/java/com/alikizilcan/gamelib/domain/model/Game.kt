package com.alikizilcan.gamelib.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: Int,
    val name: String,
    val image: String,
    val rating: String,
    val genres: String,
    val favorite: Boolean = false,
) : Parcelable

