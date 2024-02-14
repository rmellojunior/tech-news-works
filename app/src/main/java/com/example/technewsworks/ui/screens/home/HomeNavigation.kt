package com.example.technewsworks.ui.screens.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.technewsworks.ui.navigation.NavigatorEvent
import com.example.technewsworks.ui.navigation.NavigatorImpl
import com.example.technewsworks.ui.screens.news.NewsDetailNavigation

class HomeNavigation(
    private val navigator: NavigatorImpl = NavigatorImpl,
) {
    fun toNewsDetail() {
        navigator.navigate(
            NavigatorEvent.Directions(
                destination = NewsDetailNavigation.route(),
            )
        )
    }

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