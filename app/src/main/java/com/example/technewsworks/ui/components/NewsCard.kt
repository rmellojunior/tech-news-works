package com.example.technewsworks.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.technewsworks.R
import com.example.technewsworks.data.datasource.mock.FakeNews
import com.example.technewsworks.data.models.Article
import com.example.technewsworks.ui.theme.TechNewsWorksTheme
import com.example.technewsworks.ui.theme.pDimensions
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

/**
 * Composable function that represents the headline card.
 *
 * @param onClick Called when this card is clicked.
 * @param modifier The Modifier to be applied to this card.
 */
@Composable
fun NewsCard(
    article: Article,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = MaterialTheme.pDimensions.padding)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.pDimensions.cardSpaceBy),
    ) {
        NewsImage(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            imageUrl = article.urlToImage,
        )
        Column(
            modifier = Modifier.weight(3f),
        ) {
            NewsTitle(title = article.title ?: "")
            NewsAuthorAndDate(author = article.author ?: "", date = article.publishedAt ?: "")
        }
    }
}

/**
 * Composable function that represents the image of the headline card.
 *
 * @param imageUrl The URL to the relevant image to be display in this card.
 * @param modifier The Modifier to be applied to this card.
 */
@Composable
fun NewsImage(
    imageUrl: String?,
    modifier: Modifier = Modifier
) {
    GlideImage(
        modifier = modifier,
        imageModel = { imageUrl },
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
        ),
        previewPlaceholder = painterResource(id = R.drawable.ic_launcher_background),
        failure = {
            painterResource(id = R.drawable.ic_launcher_background)
        },
    )
}

/**
 * Composable function that represents the title of the headline card.
 *
 * @param title The title to be display in this card
 * @param modifier The Modifier to be applied to this card.
 */
@Composable
fun NewsTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = title,
        style = MaterialTheme.typography.titleMedium,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
    )
}

/**
 * Composable function that represents the author and date of the headline card.
 *
 * @param author The author to be display in this card.
 * @param date The date to be display in this card.
 * @param modifier The Modifier to be applied to this card.
 */
@Composable
fun NewsAuthorAndDate(
    author: String,
    date: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(
                id = R.string.card_title_format,
                formatArgs = arrayOf(author, date)
            ),
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
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
fun NewsCardPreview() {
    TechNewsWorksTheme {
        Surface {
            NewsCard(
                article = FakeNews.articles[0],
                onClick = {},
            )
        }
    }
}