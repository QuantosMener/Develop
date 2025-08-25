package com.quantos.composestarter

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val KEY_COUNT = intPreferencesKey("count")

@Singleton
class PrefsRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    val count: Flow<Int> = dataStore.data.map { it[KEY_COUNT] ?: 0 }

    suspend fun increment() {
        dataStore.edit { prefs ->
            val current = prefs[KEY_COUNT] ?: 0
            prefs[KEY_COUNT] = current + 1
        }
    }
}
