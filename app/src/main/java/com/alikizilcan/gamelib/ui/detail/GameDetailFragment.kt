package com.alikizilcan.gamelib.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alikizilcan.gamelib.databinding.FragmentGameDetailBinding
import com.alikizilcan.gamelib.infra.bases.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GameDetailFragment : BaseFragment() {

    private var _binding: FragmentGameDetailBinding? = null
    val binding get() = _binding!!

    override val viewModel: GameDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        setupVM()
        return binding.root
    }

    private fun setupVM(){
        with(viewModel){
            fetchGame()
            getGameByIdFromLocal()

            errorState.observe(viewLifecycleOwner){
                showSnackbar(it, requireView())
            }
        }
    }


}