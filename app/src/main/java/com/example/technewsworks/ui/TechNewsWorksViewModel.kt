package com.example.technewsworks.ui

import androidx.lifecycle.ViewModel
import com.example.technewsworks.ui.navigation.Navigator
import com.example.technewsworks.ui.navigation.NavigatorImpl

class TechNewsWorksViewModel(
    val navigator: Navigator = NavigatorImpl,
) : ViewModel()