package com.ezdev.counter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    private fun startCounter() {
        viewModelScope.launch {
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
    }

    fun stopCounter() {
        _uiState.update { currentState ->
            currentState.copy(isRunning = false)
        }
    }

    private fun resetCounter() {
        _uiState.update {
            HomeUiState()
        }
    }

     fun switchCounter() {
        when (_uiState.value.isRunning) {
            true -> resetCounter()
            false -> startCounter()
        }
    }

}