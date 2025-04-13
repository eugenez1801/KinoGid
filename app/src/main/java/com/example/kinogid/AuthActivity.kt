package com.example.kinogid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class AuthActivity : AppCompatActivity() {
    private lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        preferencesManager = PreferencesManager(this)
        lifecycleScope.launch {
            /*preferencesManager.rememberMeFlow.collect{ rememberMe ->это работает как observe
                if(rememberMe){
                    val userLogin = preferencesManager.userLoginFlow.first()
                    if (!userLogin.isNullOrEmpty()){
                        val intent: Intent
                        intent = MainActivity.newIntent(this@AuthActivity, userLogin)
                        startActivity(intent)
                        finish()
                    }
                }
                else {//показываем фрагмент только если rememberMe == false (или null?)
                    val currentFragment =
                        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                    if (currentFragment == null) {
                        val fragment = AuthorizationFragment.newInstance()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.nav_host_fragment, fragment)//сделал replace вместо add изначального
                            .commit()
                    }
                }
            }*/
            val rememberMe = preferencesManager.rememberMeFlow.first()//а это один раз проверить и все
            if(rememberMe){
                val userLogin = preferencesManager.userLoginFlow.first()
                if (!userLogin.isNullOrEmpty()){
                    val intent: Intent
                    intent = MainActivity.newIntent(this@AuthActivity, userLogin)
                    startActivity(intent)
                    finish()
                }
            }
            else {//показываем фрагмент только если rememberMe == false (или null?)
                val currentFragment =
                    supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                if (currentFragment == null) {
                    val fragment = AuthorizationFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment)//сделал replace вместо add изначального
                        .commit()
                }
            }
        }
    }
}