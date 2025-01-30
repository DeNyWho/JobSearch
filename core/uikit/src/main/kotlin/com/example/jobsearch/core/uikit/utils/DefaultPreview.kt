package com.example.jobsearch.core.uikit.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import com.example.jobsearch.core.uikit.theme.JobSearchTheme

@Composable
fun DefaultPreview(content: @Composable (ColumnScope.() -> Unit)) {
    JobSearchTheme {
        Column(
            content = content,
        )
    }
}