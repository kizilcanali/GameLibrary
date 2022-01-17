package com.alikizilcan.gamelib.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alikizilcan.gamelib.databinding.FragmentGamesListBinding
import com.alikizilcan.gamelib.infra.bases.BaseFragment
import com.alikizilcan.gamelib.ui.list.viewpager.ListViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamesListFragment : BaseFragment() {

    private var _binding: FragmentGamesListBinding? = null
    val binding get() = _binding!!

    override val viewModel: GameListViewModel by viewModels()

    private val gameListAdapter = GamesListAdapter()
    private val gamePagerAdapter = ListViewPagerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGamesListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            gamesRecyclerView.adapter = gameListAdapter
            viewPager.adapter = gamePagerAdapter
        }

        gameListAdapter.itemClickListener = viewModel.itemClickListener
        gamePagerAdapter.itemClickListener = viewModel.itemClickListener

        with(viewModel!!) {
            gamesList.observe(viewLifecycleOwner) {
                when {
                    it.size > 3 -> {
                        gamePagerAdapter.submitList(it.subList(0, 3))
                        gameListAdapter.submitList(it)
                    }
                    viewModel.searchText.value!!.length >= 3 -> {
                        gameListAdapter.submitList(it)
                    }
                }
                binding.viewPagerCircleIndicator.setViewPager(binding.viewPager)
            }
            searchText.observe(viewLifecycleOwner) {
                searchGame(it)
            }
        }


    }

}