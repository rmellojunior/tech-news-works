package com.example.technewsworks.ui.screens.news

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.technewsworks.ui.navigation.BaseNavigation
import com.example.technewsworks.ui.navigation.Navigator
import javax.inject.Inject

class NewsDetailNavigation @Inject constructor(
    override val navigator: Navigator,
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