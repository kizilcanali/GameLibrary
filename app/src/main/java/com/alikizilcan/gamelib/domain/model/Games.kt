package com.alikizilcan.gamelib.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Games(
    val results: List<Game>
) : Parcelable
