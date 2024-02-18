package com.example.technewsworks.ui.navigation

import androidx.navigation.NavOptions

sealed class NavigatorEvent {
    data object NavigateUp : NavigatorEvent()
    data class Directions constructor(
        val destination: String,
        val args: Map<String, Any?>? = null,
        val navOptions: NavOptions? = null,
    ) : NavigatorEvent()
}