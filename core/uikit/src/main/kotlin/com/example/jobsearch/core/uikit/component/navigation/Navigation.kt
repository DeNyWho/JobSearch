package com.example.jobsearch.core.uikit.component.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.jobsearch.core.uikit.theme.basicBlack
import com.example.jobsearch.core.uikit.theme.basicGreyFourth
import com.example.jobsearch.core.uikit.theme.blue

@Composable
fun RowScope.JobSearchNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    icon: @Composable () -> Unit,
    label: @Composable (() -> Unit)? = null,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = blue,
            unselectedIconColor = basicGreyFourth,
            selectedTextColor = blue,
            unselectedTextColor = basicGreyFourth,
            indicatorColor = Color.Transparent,
        ),
    )
}

@Composable
fun JobSearchNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        content = content,
        containerColor = basicBlack,
    )
}
