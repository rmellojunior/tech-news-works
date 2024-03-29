package com.example.technewsworks.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val mediumSpacerSize: Dp = 16.dp,
    val smallSpacerSize: Dp = 8.dp,

    val padding: Dp = 12.dp,

    // card
    val cardElevation: Dp = 10.dp,
    val cardSpaceBy: Dp = 8.dp,
)

val LocalDimensions = staticCompositionLocalOf { Dimensions() }

val MaterialTheme.pDimensions
    @Composable
    @ReadOnlyComposable
    get() = LocalDimensions.current