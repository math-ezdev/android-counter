package com.ezdev.counter.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ezdev.counter.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel = viewModel()) {
    val uiState = viewModel.uiState
    val count = when (uiState.count > 0) {
        true -> uiState.count.toString()
        false -> stringResource(R.string.click_to_start_counter)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .clickable {
                when (uiState.isRunning) {
                    true -> viewModel.resetCounter()
                    false -> viewModel.startCounter()
                }
            }
    ) {
        Text(text = count, modifier = Modifier.clickable {
            viewModel.stopCounter()
        })
    }
}