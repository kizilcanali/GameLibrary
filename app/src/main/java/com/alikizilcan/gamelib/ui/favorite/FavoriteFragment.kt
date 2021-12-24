package com.alikizilcan.gamelib.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alikizilcan.gamelib.R
import com.alikizilcan.gamelib.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val viewModel: FavoriteViewModel by viewModels()

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
            favoriteAdapter.itemClickListener = itemClickListener

            favoriteGames.observe(viewLifecycleOwner) {
                favoriteAdapter.submitList(it)
            }
        }
    }

}