package com.alikizilcan.gamelib.infra.bases

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alikizilcan.gamelib.infra.navigation.NavigationObserver
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


abstract class BaseFragment : Fragment(){

    abstract val viewModel: BaseViewModel
    private val navigationObserver = NavigationObserver()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationObserver.observeNavigation(viewModel.baseNavigation, findNavController(), viewLifecycleOwner)
    }

    fun showSnackbar(messageText: String, view: View){
        Snackbar.make(view, messageText, Snackbar.LENGTH_LONG).show()
    }
}