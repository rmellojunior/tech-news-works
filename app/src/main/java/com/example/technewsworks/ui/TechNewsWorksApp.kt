package com.example.technewsworks.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.technewsworks.ui.navigation.NavigatorEvent
import com.example.technewsworks.ui.screens.biometric.BiometricNavigation
import com.example.technewsworks.ui.screens.biometric.BiometricNavigation.Companion.biometricScreen
import com.example.technewsworks.ui.screens.home.HomeNavigation.Companion.homeScreen
import com.example.technewsworks.ui.screens.news.NewsDetailNavigation.Companion.newsDetailsScreen

@Composable
fun TechNewsWorksApp(
    viewModel: TechNewsWorksViewModel = TechNewsWorksViewModel(),
) {
    val navController = rememberNavController()

    // Collects when a navigation is triggered
    LaunchedEffect(navController) {
        viewModel.navigator.destinations.collect {
            when(it) {
                is NavigatorEvent.NavigateUp -> navController.navigateUp()
                is NavigatorEvent.Directions -> {
                    val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
                    it.args?.forEach { arg ->
                        savedStateHandle?.set(arg.key, arg.value)
                    }

                    navController.navigate(
                        route = it.destination,
                        navOptions = it.navOptions,
                    )
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = BiometricNavigation.route(),
        ) {
            biometricScreen()
            homeScreen()
            newsDetailsScreen(navController)
        }
    }
}