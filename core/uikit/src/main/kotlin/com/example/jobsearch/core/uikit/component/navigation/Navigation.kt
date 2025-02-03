package com.example.jobsearch.core.uikit.component.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
    badgeCount: Int = 0,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Box {
                icon()
                if (badgeCount > 0) {
                    Badge(
                        modifier = Modifier
                            .size(13.dp)
                            .align(Alignment.TopEnd)
                            .offset(x = 6.dp, y = (-3).dp),
                        containerColor = Color.Red,
                        contentColor = Color.White,
                    ) {
                        Text(
                            text = badgeCount.toString(),
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                }
            }
        },
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
