package com.example.technewsworks

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.technewsworks.ui.screens.home.HomeNavigation
import com.example.technewsworks.ui.screens.home.HomeNavigation.Companion.homeScreen
import com.example.technewsworks.ui.screens.news.NewsDetailNavigation.Companion.newsDetailsScreen

@Composable
fun TechNewsWorksApp() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = HomeNavigation.route(),
        ) {
            homeScreen()
            newsDetailsScreen()
        }
    }
}