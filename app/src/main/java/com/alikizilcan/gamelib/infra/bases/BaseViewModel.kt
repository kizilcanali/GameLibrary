package com.alikizilcan.gamelib.infra.bases

import androidx.lifecycle.ViewModel
import com.alikizilcan.gamelib.infra.navigation.Navigation

abstract class BaseViewModel : ViewModel(){
    val baseNavigation = Navigation()
}