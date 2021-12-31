package com.alikizilcan.gamelib.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alikizilcan.gamelib.domain.GameUseCase
import com.alikizilcan.gamelib.domain.model.Game
import com.alikizilcan.gamelib.infra.Resource
import com.alikizilcan.gamelib.infra.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameListViewModel @Inject constructor(
    private val gameUseCase: GameUseCase
    ) : BaseViewModel() {

    private val _gamesList: MutableLiveData<List<Game>> = MutableLiveData()
    val gamesList: LiveData<List<Game>> = _gamesList

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _hasNoResult: MutableLiveData<Boolean> = MutableLiveData()
    val hasNoResult: LiveData<Boolean> = _hasNoResult

    private val _errorState: MutableLiveData<String> = MutableLiveData()
    val errorState: LiveData<String> = _errorState

    init {
        fetchAllGames()
    }

    val itemClickListener: (Game) -> Unit = {
        val action = GamesListFragmentDirections.goGameListToGameDetail(it.id)
        baseNavigation.navigate(action)
    }

    private fun fetchAllGames(){
        viewModelScope.launch {
            gameUseCase.listAllGames().collect { resource ->
                when(resource){
                    is Resource.Success -> {
                        _gamesList.value = resource.data!!
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        _errorState.value = resource.exception?.message ?: ""
                        _isLoading.value = false
                        _hasNoResult.value = true
                    }
                    is Resource.Loading -> {
                        _isLoading.value = true
                        _hasNoResult.value = false
                    }
                }
            }
        }
    }
}