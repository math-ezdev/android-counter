package com.ezdev.counter.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    suspend fun startCounter() {
        _uiState.update { currentState ->
            currentState.copy(isRunning = true)
        }
        delay(1000L)

        while (_uiState.value.isRunning) {

            _uiState.update { currentState ->
                currentState.copy(count = currentState.count + 1)
            }
            delay(1000L)
        }
    }

    fun stopCounter() {
        _uiState.update { currentState ->
            currentState.copy(isRunning = false)
        }
    }

    fun resetCounter() {
        _uiState.update {
            HomeUiState()
        }
    }


}