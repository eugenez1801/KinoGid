package com.example.kinogid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)
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