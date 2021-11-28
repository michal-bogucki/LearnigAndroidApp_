package com.learnig.android.app.feature

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.learnig.android.app.R
import com.learnig.android.app.base.BaseActivity
import com.learnig.android.app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        val navController = this.findNavController(R.id.nav_host_fragment)
        val navView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(navigationListener)
    }

    private val navigationListener =
        NavController.OnDestinationChangedListener { _, navDestination: NavDestination, _ ->

            when (navDestination.id) {
                R.id.characterFragment -> bottom_nav_view.visibility = GONE
                R.id.characterListFragment -> bottom_nav_view.visibility = VISIBLE
                R.id.episodeFragment -> bottom_nav_view.visibility = GONE
                R.id.episodeListFragment -> bottom_nav_view.visibility = VISIBLE
                R.id.locationFragment -> bottom_nav_view.visibility = GONE
                R.id.locationListFragment -> bottom_nav_view.visibility = VISIBLE
            }
        }

    override fun getViewBinding(): ActivityMainBinding  = ActivityMainBinding.inflate(layoutInflater)
}