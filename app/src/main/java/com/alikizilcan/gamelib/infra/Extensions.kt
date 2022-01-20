package com.alikizilcan.gamelib.infra

import com.alikizilcan.gamelib.data.remote.models.detail.GenreResponse

fun Int?.orZero() = this ?: 0

fun Double?.orZero() = this ?: 0.0

fun List<GenreResponse>.mergeTexts(genres: List<GenreResponse>): String{
    var str: String = ""
    for(i in genres){
        if(i == genres.get(genres.size - 1)){
            str = str.plus(i.genreName)
        } else {
            str = str.plus(i.genreName)  + ", "
        }
    }
    return str
}

