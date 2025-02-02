package com.example.jobsearch.core.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorScheme = darkColorScheme(
    background = basicBlack,
    onBackground = Color.White,
    surface = basicGreyFirst,
    onSurface = Color.White,
    onSurfaceVariant = basicGreyFifth,
    primaryContainer = green,
    onPrimary = Color.White,
)


val LightColorScheme = lightColorScheme(
    background = basicBlack,
    onBackground = Color.White,
    surface = basicGreyFirst,
    onSurface = Color.White,
    onSurfaceVariant = basicGreyFifth,
    primaryContainer = green,
    onPrimary = Color.White,
)

@Composable
fun JobSearchTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if(!darkTheme) {
        LightColorScheme
    } else {
        DarkColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = jobSearchTypography(),
        content = content,
    )
}