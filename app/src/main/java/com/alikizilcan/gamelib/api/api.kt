package com.alikizilcan.gamelib.api

import com.alikizilcan.gamelib.tools.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private var _api: GameLibraryApi? = null
val api get() = _api!!


fun generateApi(){

    if(_api != null) return

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    _api = retrofit.create(GameLibraryApi::class.java)
}

