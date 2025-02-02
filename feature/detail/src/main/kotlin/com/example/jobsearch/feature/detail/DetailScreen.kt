package com.example.jobsearch.feature.detail

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
internal fun DetailScreen() {
    DetailUI()
}

@Composable
private fun DetailUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.feature_detail_screen_name),
            style = MaterialTheme.typography.displayLarge,
            color = Color.White,
        )
    }
}

@Preview
@Composable
private fun PreviewDetailUI() {
    DefaultPreview {
        DetailUI()
    }
}