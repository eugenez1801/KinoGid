package com.example.kinogid

import ViewModelFactory
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.kinogid.database.AppDatabase

private const val LOGIN_OF_USER = "user_login"

private lateinit var currentUser: User

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
                val fragmentRegistration = RecommendationsFragment.newInstance()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragmentRegistration)
                transaction.addToBackStack(null)
                transaction.commit()
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