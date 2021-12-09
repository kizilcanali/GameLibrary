package com.alikizilcan.gamelib.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alikizilcan.gamelib.domain.GameUseCase
import com.alikizilcan.gamelib.domain.model.Games
import com.alikizilcan.gamelib.infra.Resource
import com.alikizilcan.gamelib.infra.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameListViewModel @Inject constructor(private val gameUseCase: GameUseCase) : BaseViewModel() {

    private var _gamesList: MutableLiveData<Games> = MutableLiveData()
    val gamesList: LiveData<Games> = _gamesList

    init {
        fetchAllGames()
    }

    private fun fetchAllGames(){
        viewModelScope.launch {
            gameUseCase.listAllGames().collect { resource ->
                when(resource){
                    is Resource.Success -> {
                        _gamesList.value = resource.data
                    }
                    is Resource.Error -> {
                        Log.i("ERROR", resource.exception?.message.orEmpty())
                    }
                    is Resource.Loading -> {
                        Log.i("LOADING", "LOADING")
                    }
                }
            }
        }
    }
}