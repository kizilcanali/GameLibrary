package com.alikizilcan.gamelib.api

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private var _api: GameLibraryApi? = null
val api get() = _api!!

const val BASE_URL = "https://api.rawg.io/api"

fun generateApi(){

    if(_api != null) return

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    _api = retrofit.create(GameLibraryApi::class.java)
}

