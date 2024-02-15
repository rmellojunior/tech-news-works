package com.example.technewsworks.ui.screens.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.technewsworks.ui.navigation.BaseNavigation
import com.example.technewsworks.ui.navigation.Navigator
import com.example.technewsworks.ui.navigation.NavigatorEvent
import com.example.technewsworks.ui.screens.news.NewsDetailNavigation
import javax.inject.Inject

class HomeNavigation @Inject constructor(
    override val navigator: Navigator,
) : BaseNavigation() {
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