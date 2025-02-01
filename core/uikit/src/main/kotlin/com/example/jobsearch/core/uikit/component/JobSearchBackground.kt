package com.example.jobsearch.core.uikit.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JobSearchBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Surface (
        color = MaterialTheme.colorScheme.background,
        modifier = modifier.fillMaxSize()
    ) {
        content()
    }
}