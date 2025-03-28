package com.example.kinogid

import ViewModelFactory
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.kinogid.database.AppDatabase
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
        val userRepository = UserRepository(userDao)

        val factory = ViewModelFactory(userRepository)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        val userLogin = intent.getStringExtra(LOGIN_OF_USER)!!
        viewModel.getUserByLogin(userLogin)
        //запускаем фрагмент только после того, как user будет иметь значение
        viewModel.user.observe(this){ user ->
            if (user != null) {
                val navHostFragment = supportFragmentManager
                    .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                navController = navHostFragment.navController

                navController.setGraph(R.navigation.nav_graph)

                val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
                bottomNav.setupWithNavController(navController)

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