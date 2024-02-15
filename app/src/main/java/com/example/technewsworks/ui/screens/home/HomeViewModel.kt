package com.example.technewsworks.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.technewsworks.data.datasource.MockData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val navigation: HomeNavigation,
) : ViewModel() {
    val headlines = MockData.articles
}