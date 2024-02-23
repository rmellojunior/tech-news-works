package com.example.technewsworks.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.technewsworks.R
import com.example.technewsworks.ui.theme.TechNewsWorksTheme
import com.example.technewsworks.ui.theme.pDimensions

@Composable
fun PagingLoadingItem(
    modifier: Modifier = Modifier,
) {
    LinearProgressIndicator(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = MaterialTheme.pDimensions.padding),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}

@Composable
fun PagingEmptyItem(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = MaterialTheme.pDimensions.padding),
        text = stringResource(id = R.string.home_no_news),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun PagingErrorItem(
    onTryAgainClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = MaterialTheme.pDimensions.padding),
        onClick = onTryAgainClick
    ) {
        Text(text = "Try Again")
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
fun PagingItemsPreview() {
    TechNewsWorksTheme {
        Column {
            PagingLoadingItem()
            PagingEmptyItem()
            PagingErrorItem(onTryAgainClick = { })
        }
    }
}