package com.example.technewsworks.ui.navigation

abstract class BaseNavigation {
    abstract val navigator: Navigator

    fun back() = navigator.navigate(NavigatorEvent.NavigateUp)
}