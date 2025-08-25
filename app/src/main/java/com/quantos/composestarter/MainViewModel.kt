package com.quantos.composestarter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainUiState(val count: Int = 0)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: PrefsRepository
) : ViewModel() {

    val uiState: StateFlow<MainUiState> =
        repo.count.map { MainUiState(it) }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), MainUiState())

    fun increment() = viewModelScope.launch {
        repo.increment()
    }
}
