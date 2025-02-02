package com.example.jobsearch.core.uikit.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jobsearch.core.uikit.R

private val SFProDisplayFontFamily = FontFamily(
    Font(R.font.sf_pro_display_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.sf_pro_display_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold, FontStyle.Normal),
)

internal fun jobSearchTypography(): Typography {
    return Typography(
        displayLarge = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            fontFamily = SFProDisplayFontFamily,
        ),
        displayMedium = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            fontFamily = SFProDisplayFontFamily,
        ),
        headlineLarge = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            fontFamily = SFProDisplayFontFamily,
        ),
        headlineMedium = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            fontFamily = SFProDisplayFontFamily,
        ),
        bodyLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            fontFamily = SFProDisplayFontFamily,
        ),
        labelLarge = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            fontFamily = SFProDisplayFontFamily,
        ),
        labelMedium = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            fontFamily = SFProDisplayFontFamily,
        ),
        labelSmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            fontFamily = SFProDisplayFontFamily,
        ),
        bodySmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 7.sp,
            fontFamily = SFProDisplayFontFamily,
        ),
    )
}