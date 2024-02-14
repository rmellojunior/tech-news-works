package com.example.technewsworks.ui.screens.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

class HomeNavigation {
    companion object {
        private const val route = "home_route"

        fun route() = route

        fun NavGraphBuilder.homeScreen() {
            composable(route = route()) {
                HomeScreen()
            }
        }
    }
}