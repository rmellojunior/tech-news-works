package com.example.technewsworks.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technewsworks.data.models.Article
import com.example.technewsworks.data.models.CountryCode
import com.example.technewsworks.data.repo.HeadlinesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val navigation: HomeNavigation,
    private val headlinesRepo: HeadlinesRepo,
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = HomeUiState.Loading
        // Trigger repository requests in parallel
        viewModelScope.launch(Dispatchers.IO) {
            val newsProviderDeferred = async { headlinesRepo.getNewsProvider() }
            val topHeadlinesDeferred = async { headlinesRepo.getTopHeadlines(country = CountryCode.UNITED_STATES) }

            // Wait for all requests to finish
            val newsProvider = newsProviderDeferred.await()
            val topHeadlines = topHeadlinesDeferred.await()

            _uiState.value = HomeUiState.Success(
                newsProvider = newsProvider,
                topHeadlines = topHeadlines,
            )
        }
    }
}

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Success(
        val newsProvider: String,
        val topHeadlines: List<Article>
    ) : HomeUiState()
}