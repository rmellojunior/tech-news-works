package com.example.technewsworks.ui.screens.news

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

class NewsDetailNavigation {
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