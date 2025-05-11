package com.example.kinogid.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_prefs")
class PreferencesManager(private val context: Context) {
    companion object {
        val REMEMBER_ME = booleanPreferencesKey("remember_me")
        val USER_LOGIN = stringPreferencesKey("user_login")
    }

    suspend fun saveUserSession(userLogin: String, rememberMe: Boolean){
        context.dataStore.edit { prefs ->
            prefs[USER_LOGIN] = userLogin
            prefs[REMEMBER_ME] = rememberMe
        }
    }

    val userLoginFlow: Flow<String?> = context.dataStore.data.map { prefs ->
        prefs[USER_LOGIN]
    }
    val rememberMeFlow: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[REMEMBER_ME] ?: false
    }

    suspend fun clearSession(){
        context.dataStore.edit { prefs ->
            prefs.remove(USER_LOGIN)
            prefs.remove(REMEMBER_ME)
        }
    }
}