package com.example.technewsworks.ui.navigation

import androidx.navigation.NavOptions

sealed class NavigatorEvent {
    data object NavigateUp : NavigatorEvent()
    data class Directions constructor(
        val destination: String,
        val navOptions: NavOptions? = null,
    ) : NavigatorEvent()
}