package com.example.technewsworks.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.technewsworks.R
import com.example.technewsworks.data.datasource.mock.FakeNews
import com.example.technewsworks.data.models.Article
import com.example.technewsworks.ui.components.NewsCard
import com.example.technewsworks.ui.components.PagingEmptyItem
import com.example.technewsworks.ui.components.PagingErrorItem
import com.example.technewsworks.ui.components.PagingLoadingItem
import com.example.technewsworks.ui.components.SimpleAppBar
import com.example.technewsworks.ui.theme.TechNewsWorksTheme
import com.example.technewsworks.ui.theme.pDimensions
import kotlinx.coroutines.flow.flowOf

/**
 * Composable function that represents the home screen.
 *
 * @param modifier The Modifier to be applied to this screen.
 * @param vm View model.
 */
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    vm: HomeViewModel = hiltViewModel(),
) {
    val articles = vm.getTopHeadlines().collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SimpleAppBar(title = stringResource(id = R.string.home_provider))
        },
    ) { innerPadding ->
        HomePage(
            modifier = modifier.padding(innerPadding),
            topHeadlines = articles,
            onNewsClicked = { vm.navigation.toNewsDetail(it) },
        )
    }
}

/**
 * Composable function that represents the home page.
 *
 * @param modifier The Modifier to be applied to this page.
 * @param topHeadlines Top headlines for a specific source.
 * @param onNewsClicked Called when a headline is clicked.
 */
@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    topHeadlines: LazyPagingItems<Article>,
    onNewsClicked: (Article) -> Unit,
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
            item {
                when (topHeadlines.loadState.refresh) {
                    is LoadState.Loading -> PagingLoadingItem()
                    is LoadState.Error -> {
                        PagingErrorItem(onTryAgainClick = { topHeadlines.retry() })
                    }
                    is LoadState.NotLoading -> if (topHeadlines.itemCount < 1) PagingEmptyItem()
                }
            }
            items(topHeadlines.itemCount) { idx ->
                val article = topHeadlines[idx] ?: Article()
                NewsCard(
                    article = article,
                    onClick = { onNewsClicked(article) },
                )
            }
            item {
                when (topHeadlines.loadState.append) {
                    is LoadState.Loading -> PagingLoadingItem()
                    is LoadState.Error -> PagingErrorItem(onTryAgainClick = { topHeadlines.retry() })
                    is LoadState.NotLoading -> Unit
                }
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
            HomePage(
                topHeadlines = flowOf(PagingData.from(FakeNews.articles)).collectAsLazyPagingItems(),
                onNewsClicked = {},
            )
        }
    }
}