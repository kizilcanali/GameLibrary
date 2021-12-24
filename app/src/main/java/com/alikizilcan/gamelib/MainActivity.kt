package com.alikizilcan.gamelib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.alikizilcan.gamelib.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostContainer) as NavHostFragment

        navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{_, navDestination: NavDestination, _ ->
            if(navDestination.id == R.id.gameDetailFragment){
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }


    }
}