package com.elionet.ecommerceappmvvm.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.elionet.ecommerceappmvvm.core.Config.AUTH_KEY
import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthDataStore constructor(private val dataStore: DataStore<Preferences>){

    suspend fun saveUser(authResponse: AuthResponse){

        val dataStoreKey = stringPreferencesKey(AUTH_KEY)

        dataStore.edit { preferences ->
            preferences[dataStoreKey] = authResponse.toJson()
        }
    }

    suspend fun delete(){

        val dataStoreKey = stringPreferencesKey(AUTH_KEY)

        dataStore.edit { preferences ->
            preferences.remove(dataStoreKey)
        }
    }

    fun getData(): Flow<AuthResponse> {

        val dataStoreKey = stringPreferencesKey(AUTH_KEY)

        return dataStore.data.map { preferences ->
            if(preferences[dataStoreKey] != null){
                AuthResponse.fromJson(preferences[dataStoreKey]!!)
            }else{
                AuthResponse()
            }
        }
    }
}