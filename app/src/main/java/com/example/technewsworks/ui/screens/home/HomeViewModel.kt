package com.example.technewsworks.ui.screens.home

import com.example.technewsworks.data.datasource.MockData

class HomeViewModel(
    val navigation: HomeNavigation = HomeNavigation()
) {
    val headlines = MockData.articles
}