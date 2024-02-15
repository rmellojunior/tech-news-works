package com.example.technewsworks.ui.screens.news

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.technewsworks.ui.components.SimpleAppBar
import com.example.technewsworks.ui.theme.TechNewsWorksTheme

/**
 * Composable function that represents the news detail screen.
 *
 * @param modifier The Modifier to be applied to this screen.
 * @param vm View model.
 */
@Composable
fun NewsDetailScreen(
    modifier: Modifier = Modifier,
    vm: NewsDetailViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = { SimpleAppBar(navigateUp = vm.navigation::back) },
    ) { innerPadding ->
        NewsDetailPage(
            modifier = modifier.padding(innerPadding),
        )
    }
}

/**
 * Composable function that represents the news detail page.
 *
 * @param modifier The Modifier to be applied to this page.
 */
@Composable
fun NewsDetailPage(
    modifier: Modifier = Modifier,
) {
    Text(text = "Hello World")
}

@Preview(
    name = "Light Theme",
    showBackground = true
)
@Preview(
    name = "Dark Theme",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Composable
internal fun NewsDetailPreview() {
    TechNewsWorksTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NewsDetailPage()
        }
    }
}