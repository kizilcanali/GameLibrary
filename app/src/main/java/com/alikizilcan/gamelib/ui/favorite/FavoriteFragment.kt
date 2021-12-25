package com.alikizilcan.gamelib.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alikizilcan.gamelib.R
import com.alikizilcan.gamelib.databinding.FragmentFavoriteBinding
import com.alikizilcan.gamelib.infra.bases.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoriteBinding
    override val viewModel: FavoriteViewModel by viewModels()

    private val favoriteAdapter = FavoriteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        setupView()
        return binding.root
    }


    private fun setupView() {
        with(viewModel) {

            getFavorites()

            binding.favoriteRecyclerView.adapter = favoriteAdapter

            favoriteGames.observe(viewLifecycleOwner) {
                favoriteAdapter.submitList(it)
            }
            favoriteAdapter.itemClickListener = itemClickListener
        }
    }

}