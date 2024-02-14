package com.example.technewsworks.ui.screens.news

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.technewsworks.ui.navigation.BaseNavigation
import com.example.technewsworks.ui.navigation.Navigator
import com.example.technewsworks.ui.navigation.NavigatorImpl

class NewsDetailNavigation(
    override val navigator: Navigator = NavigatorImpl,
) : BaseNavigation() {
    companion object {
        private const val route = "news_details_route"

        fun route() = route

        fun NavGraphBuilder.newsDetailsScreen() {
            composable(route = route()) {
                NewsDetailScreen()
            }
        }
    }
}