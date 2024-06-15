package com.ezdev.counter.presentation

data class HomeUiState(
    val count: Int = 0,
    val isRunning: Boolean = false
)