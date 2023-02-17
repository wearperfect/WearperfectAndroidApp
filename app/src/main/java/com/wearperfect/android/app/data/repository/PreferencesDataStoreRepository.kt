package com.wearperfect.android.app.data.repository

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferencesDataStoreRepository @Inject constructor(private val dataStore: DataStore<Preferences>) {

    fun getAccessToken(): Flow<String?>{
        return dataStore.data.map { preferences ->
            Log.i("PreferencesDataStoreRepository", "getAccessToken: ${preferences[ACCESS_TOKEN_KEY]}")
            preferences[ACCESS_TOKEN_KEY]
        }
    }

    suspend fun insertAccessToken(accessToken: String){
        dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN_KEY] = accessToken
        }
    }

    suspend fun deleteAccessToken(){
        dataStore.edit { preferences ->
            preferences.remove(ACCESS_TOKEN_KEY)
        }
    }

    companion object {
        private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
    }
}