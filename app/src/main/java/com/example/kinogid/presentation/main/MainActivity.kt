package com.example.kinogid.presentation.main

import com.example.kinogid.di.ViewModelFactory
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.kinogid.domain.usecases.GetRecommendationsUseCase
import com.example.kinogid.R
import com.example.kinogid.domain.recommendation.RecommendationEngine
import com.example.kinogid.data.repository.Repository
import com.example.kinogid.data.database.AppDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LOGIN_OF_USER = "user_login"

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "app_database"
        ).build()
        val userDao = database.userDao()
        val repository = Repository(userDao)
        val recommendationEngine = RecommendationEngine()
        val recommendationsUseCase = GetRecommendationsUseCase(repository, recommendationEngine)

        val factory = ViewModelFactory(repository, recommendationsUseCase)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val userLogin = intent.getStringExtra(LOGIN_OF_USER)!!
        viewModel.getUserByLogin(userLogin)
        //запускаем фрагмент только после того, как user будет иметь значение
        viewModel.user.observe(this){ user ->
            if (user != null) {
                val navHostFragment = supportFragmentManager
                    .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                navController = navHostFragment.navController
                navController.setGraph(R.navigation.nav_graph)
                bottomNav.setupWithNavController(navController)

                navController.addOnDestinationChangedListener { _, destination, _ ->
                    if(destination.id == R.id.movieFragment || destination.id == R.id.detailWatchedListFragment || destination.id == R.id.detailListFragment) {
                        bottomNav.visibility = View.GONE
                    } else {
                        bottomNav.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    companion object {
        fun newIntent(packageContext: Context, login: String): Intent {
            return Intent(packageContext, MainActivity::class.java).apply {
                putExtra(LOGIN_OF_USER, login)
            }
        }
    }
}