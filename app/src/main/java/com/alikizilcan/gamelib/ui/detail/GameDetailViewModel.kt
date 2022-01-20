package com.alikizilcan.gamelib.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.alikizilcan.gamelib.domain.GameDetailUseCase
import com.alikizilcan.gamelib.domain.model.GameDetail
import com.alikizilcan.gamelib.infra.Resource
import com.alikizilcan.gamelib.infra.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val gameDetailUseCase: GameDetailUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _game: MutableLiveData<GameDetail> = MutableLiveData()
    val game: LiveData<GameDetail> = _game

    private var _isFav: MutableLiveData<Boolean> = MutableLiveData()
    val isFav: LiveData<Boolean> = _isFav

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorState: MutableLiveData<String> = MutableLiveData()
    val errorState: LiveData<String> = _errorState

    private val gameId: Int = savedStateHandle["gameId"]!!

    init {
        fetchGame()
    }

    fun fetchGame() {
        viewModelScope.launch {
            gameDetailUseCase.getGameById(gameId).collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _game.value = resource.data!!
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        _errorState.value = resource.exception?.message ?: ""
                        _isLoading.value = false
                    }
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                }
            }
        }
    }

    fun getGameByIdFromLocal() {
        viewModelScope.launch {
            gameDetailUseCase.getGameByIdFromLocal(gameId).collect {
                _isFav.value = it.favorite
            }
        }
    }

    fun addFavorite() {
        viewModelScope.launch {
            gameDetailUseCase.updateFavorite(!_isFav.value!!, gameId)
        }
    }

}