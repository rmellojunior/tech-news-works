package com.example.technewsworks.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.technewsworks.data.repo.headlines.HeadlinesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val navigation: HomeNavigation,
    private val headlinesRepo: HeadlinesRepo,
) : ViewModel() {
    fun getNewsProvider() = headlinesRepo.getNewsProvider()
    fun getTopHeadlines() = headlinesRepo.getTopHeadlines().cachedIn(viewModelScope)
}