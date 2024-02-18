package com.example.technewsworks.ui.screens.news

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    val navigation: NewsDetailNavigation,
) : ViewModel()