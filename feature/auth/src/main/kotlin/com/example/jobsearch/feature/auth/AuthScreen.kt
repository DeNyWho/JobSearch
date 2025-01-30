package com.example.jobsearch.feature.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobsearch.core.uikit.theme.basicBlack
import com.example.jobsearch.core.uikit.utils.DefaultPreview

@Composable
internal fun AuthScreen(
    viewModel: AuthViewModel = hiltViewModel(),
) {
    AuthUI()
}

@Composable
private fun AuthUI() {
    Box(
        modifier = Modifier
            .background(basicBlack)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Auth Screen",
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@PreviewScreenSizes
@Composable
private fun PreviewAuthUI() {
    DefaultPreview {
        AuthUI()
    }
}
