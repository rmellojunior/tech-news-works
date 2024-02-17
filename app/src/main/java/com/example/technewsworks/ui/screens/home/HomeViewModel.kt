package com.example.technewsworks.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.technewsworks.data.models.CountryCode
import com.example.technewsworks.data.repo.HeadlinesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val navigation: HomeNavigation,
    private val headlinesRepo: HeadlinesRepo,
) : ViewModel() {
    val newsProvider = headlinesRepo.getNewsProvider()
    val topHeadlines = headlinesRepo.getTopHeadlines(country = CountryCode.UNITED_STATES)
}