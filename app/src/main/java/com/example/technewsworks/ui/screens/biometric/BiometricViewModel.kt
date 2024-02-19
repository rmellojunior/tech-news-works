package com.example.technewsworks.ui.screens.biometric

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BiometricViewModel@Inject constructor(
    val navigation: BiometricNavigation,
) : ViewModel()