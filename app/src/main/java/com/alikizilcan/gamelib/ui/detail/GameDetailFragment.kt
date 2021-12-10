package com.alikizilcan.gamelib.ui.detail

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.alikizilcan.gamelib.R
import com.alikizilcan.gamelib.databinding.FragmentGameDetailBinding
import com.alikizilcan.gamelib.domain.GameDetailUseCase
import com.alikizilcan.gamelib.infra.bases.BaseFragment
import com.alikizilcan.gamelib.infra.bases.BaseViewModel
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
        return binding.root
    }

}