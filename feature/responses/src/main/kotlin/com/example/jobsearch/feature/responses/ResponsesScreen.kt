package com.example.jobsearch.feature.responses

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jobsearch.core.uikit.utils.DefaultPreview

@Composable
internal fun ResponsesScreen() {
    ResponsesUI()
}

@Composable
private fun ResponsesUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.feature_responses_screen_name),
            style = MaterialTheme.typography.displayLarge,
            color = Color.White,
        )
    }
}

@Preview
@Composable
private fun PreviewResponsesUI() {
    DefaultPreview {
        ResponsesUI()
    }
}