package com.example.technewsworks.ui.screens.biometric

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.technewsworks.ui.navigation.BaseNavigation
import com.example.technewsworks.ui.navigation.Navigator
import com.example.technewsworks.ui.navigation.NavigatorEvent
import com.example.technewsworks.ui.screens.home.HomeNavigation
import javax.inject.Inject

class BiometricNavigation @Inject constructor(
    override val navigator: Navigator,
) : BaseNavigation() {

    fun toHome() = navigator.navigate(
        NavigatorEvent.Directions(
            destination = HomeNavigation.route(),
            navOptions = NavOptions.Builder()
                .setPopUpTo(0, true)
                .setLaunchSingleTop(true)
                .build(),
        )
    )

    companion object {
        private const val route = "biometric_route"

        fun route() = route

        fun NavGraphBuilder.biometricScreen() {
            composable(route = route()) {
                BiometricScreen()
            }
        }
    }
}