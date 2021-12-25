package com.alikizilcan.gamelib.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alikizilcan.gamelib.domain.FavoriteUseCase
import com.alikizilcan.gamelib.domain.model.Game
import com.alikizilcan.gamelib.infra.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase
    ) : BaseViewModel() {

    private val _favoriteGames: MutableLiveData<List<Game>> = MutableLiveData()
    val favoriteGames: LiveData<List<Game>> = _favoriteGames

    fun getFavorites() {
        viewModelScope.launch {
            favoriteUseCase.getFavorites().collect {
                _favoriteGames.value = it
            }
        }
    }

    val itemClickListener: (Game) -> Unit = {
        println(it.name)
        val action = FavoriteFragmentDirections.goFavoriteToDetail(it.id)
        baseNavigation.navigate(action)
    }

}