package com.example.technewsworks.ui.navigation

import kotlinx.coroutines.flow.Flow

interface Navigator {
    val destinations: Flow<NavigatorEvent>
    fun navigate(navigatorEvent: NavigatorEvent): Boolean
}