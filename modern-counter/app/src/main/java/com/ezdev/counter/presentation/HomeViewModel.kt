package com.ezdev.counter.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set

    private fun startCounter() {
        viewModelScope.launch {
            uiState = uiState.copy(isRunning = true)
            delay(1000L)
            while (uiState.isRunning) {
                uiState = uiState.copy(count = uiState.count + 1)
                delay(1000L)
            }
        }
    }

    fun stopCounter() {
        uiState = uiState.copy(isRunning = false)
    }

    private fun resetCounter() {
        uiState = HomeUiState()
    }

    fun switchCounter() {
        when (uiState.isRunning) {
            true -> resetCounter()
            false -> startCounter()
        }
    }
}