package com.alikizilcan.gamelib.infra

import android.text.TextUtils.concat
import com.alikizilcan.gamelib.data.api.detail.GenreResponse

fun Int?.orZero() = this ?: 0

fun Double?.orZero() = this ?: 0.0

fun List<GenreResponse>.mergeTexts() = {
}