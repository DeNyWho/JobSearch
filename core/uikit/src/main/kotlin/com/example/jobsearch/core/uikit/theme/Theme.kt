package com.example.jobsearch.core.uikit.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun JobSearchTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        typography = jobSearchTypography(),
        content = content,
    )
}