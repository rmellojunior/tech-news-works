package com.example.technewsworks.ui.components

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.technewsworks.R
import com.example.technewsworks.ui.theme.TechNewsWorksTheme

/**
 * Composable function that represents the SmallAppBar.
 * Small: For screens that don't require a lot of navigation or actions.
 *
 * @param modifier The Modifier to be applied to this app bar.
 * @param title The title to be display to this app bar.
 * @param navigateUp Called when the back button is clicked.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    navigateUp: (() -> Unit)? = null,
) {
    TopAppBar(
        title = { title?.let{ Text(title) } },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = modifier,
        navigationIcon = {
            navigateUp?.let {
                IconButton(onClick = it) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                    )
                }
            }
        }
    )
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
internal fun ToolbarsPreview() {
    TechNewsWorksTheme {
        Surface {
            SimpleAppBar(
                title = stringResource(id = R.string.app_name),
                navigateUp = {},
            )
        }
    }
}