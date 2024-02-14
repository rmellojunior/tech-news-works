package com.example.technewsworks.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.technewsworks.R
import com.example.technewsworks.data.datasource.MockData
import com.example.technewsworks.data.models.Article
import com.example.technewsworks.ui.components.NewsCard
import com.example.technewsworks.ui.theme.TechNewsWorksTheme
import com.example.technewsworks.ui.theme.pDimensions

/**
 * Composable function that represents the home screen.
 *
 * @param modifier The Modifier to be applied to this screen.
 * @param vm View model.
 */
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    vm: HomeViewModel = HomeViewModel(),
) {
    Scaffold { innerPadding ->
        HomePage(
            modifier = modifier.padding(innerPadding),
            headlines = vm.headlines,
        )
    }
}

/**
 * Composable function that represents the home page.
 *
 * @param modifier The Modifier to be applied to this page.
 * @param headlines Top headlines for a specific source.
 */
@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    headlines: List<Article>,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.padding(MaterialTheme.pDimensions.padding),
            text = stringResource(id = R.string.home_label),
            style = MaterialTheme.typography.titleMedium
        )
        LazyColumn {
            items(headlines) {
                NewsCard(
                    title = it.title,
                    author = it.author,
                    date = it.publishedAt,
                    onClick = {},
                )
            }
        }
    }
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
internal fun HomePreview() {
    TechNewsWorksTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            HomePage(headlines = MockData.articles)
        }
    }
}