@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.technewsworks.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.technewsworks.R
import com.example.technewsworks.data.datasource.MockData
import com.example.technewsworks.ui.theme.TechNewsWorksTheme
import com.example.technewsworks.ui.theme.pDimensions

/**
 * Composable function that represents the headline card.
 *
 * @param title The title to be display in this card.
 * @param author The author to be display in this card.
 * @param date The date to be display in this card.
 * @param onClick Called when this card is clicked.
 * @param modifier The Modifier to be applied to this card.
 */
@Composable
fun NewsCard(
    title: String,
    author: String,
    date: String,
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
        CardImage(
            modifier = Modifier.weight(1f),
            image = painterResource(id = R.drawable.ic_launcher_background),
        )
        Column(
            modifier = Modifier.weight(3f),
        ) {
            CardTitle(title = title)
            CardAuthorAndDate(author = author, date = date)
        }
    }
}

/**
 * Composable function that represents the image of the headline card.
 *
 * @param image The image of the headline card.
 * @param modifier The Modifier to be applied to this card.
 */
@Composable
fun CardImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = image,
        contentDescription = null,
    )
}

/**
 * Composable function that represents the title of the headline card.
 *
 * @param title The title of the headline card.
 * @param modifier The Modifier to be applied to this card.
 */
@Composable
fun CardTitle(
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
 * @param author The author of the headline card.
 * @param date The date of the headline card.
 * @param modifier The Modifier to be applied to this card.
 */
@Composable
fun CardAuthorAndDate(
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
                title = MockData.articles[0].title,
                author = MockData.articles[0].author,
                date = MockData.articles[0].publishedAt,
                onClick = {},
            )
        }
    }
}