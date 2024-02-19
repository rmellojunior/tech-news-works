package com.example.technewsworks.ui.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object NavigatorImpl : Navigator {
    private val navEvents = Channel<NavigatorEvent>()
    override val destinations = navEvents.receiveAsFlow()

    override fun navigate(navigatorEvent: NavigatorEvent) {
        navEvents.trySend(navigatorEvent)
    }
}