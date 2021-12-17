package com.alikizilcan.gamelib.infra

import android.text.TextUtils.concat
import com.alikizilcan.gamelib.data.api.detail.GenreResponse

fun Int?.orZero() = this ?: 0

fun Double?.orZero() = this ?: 0.0

fun List<GenreResponse>.mergeTexts(genres: List<GenreResponse>): String{
    var str: String = ""
    for(i in genres){
        str = str.plus(i.genreName) + " "
    }
    return str
}