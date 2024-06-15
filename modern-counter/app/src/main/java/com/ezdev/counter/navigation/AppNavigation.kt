package com.ezdev.counter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.ezdev.counter.presentation.HomeScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    startDestination: Screen = Screen.Home,
    navController: NavHostController = rememberNavController()
) {
    val navGraph = navController.createGraph(startDestination) {
        composable<Screen.Home> { HomeScreen() }
    }

    NavHost(navController = navController, graph = navGraph, modifier = modifier)
}