package com.example.technewsworks.ui.screens.news

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.technewsworks.data.models.Article
import com.example.technewsworks.ui.navigation.BaseNavigation
import com.example.technewsworks.ui.navigation.Navigator
import javax.inject.Inject

class NewsDetailNavigation @Inject constructor(
    override val navigator: Navigator,
) : BaseNavigation() {
    companion object {
        private const val route = "news_details_route"
        internal const val articleArg = "article_arg"

        fun route() = route

        fun NavGraphBuilder.newsDetailsScreen(navController: NavHostController) {
            composable(route = route()) {
                NewsDetailScreen(
                    article = navController.previousBackStackEntry?.savedStateHandle?.get<Article>(articleArg)
                        ?: Article(),
                )
            }
        }
    }
}