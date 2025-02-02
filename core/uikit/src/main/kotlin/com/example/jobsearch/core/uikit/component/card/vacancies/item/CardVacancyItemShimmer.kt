package com.example.jobsearch.core.uikit.component.card.vacancies.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobsearch.core.uikit.utils.DefaultPreview
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
private fun CardVacancyItemShimmer(
    modifier: Modifier = Modifier,
    shimmerInstance: Shimmer,
) {
    Card(
        modifier = modifier
            .shimmer(shimmerInstance)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        shape = MaterialTheme.shapes.small,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Row {
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(16.dp)
                            .background(color = MaterialTheme.colorScheme.onSurfaceVariant),
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth(0.4f)
                            .height(20.dp)
                            .background(color = MaterialTheme.colorScheme.onSurfaceVariant),
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth(0.2f)
                            .height(16.dp)
                            .background(color = MaterialTheme.colorScheme.onSurfaceVariant),
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .fillMaxWidth(0.3f)
                            .height(16.dp)
                            .background(color = MaterialTheme.colorScheme.onSurfaceVariant),
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth(0.5f)
                            .height(16.dp)
                            .background(color = MaterialTheme.colorScheme.onSurfaceVariant),
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth(0.6f)
                            .height(24.dp)
                            .background(color = MaterialTheme.colorScheme.onSurfaceVariant),
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(32.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = MaterialTheme.colorScheme.onSurfaceVariant),
            )
        }
    }
}

@Composable
internal fun ColumnScope.ShowCardVacancyItemShimmer(
    modifier: Modifier = Modifier,
    shimmerInstance: Shimmer,
    count: Int = 3,
) {
    for (i in 1..count) {
        CardVacancyItemShimmer(
            modifier = modifier,
            shimmerInstance = shimmerInstance,
        )
    }
}

@Preview
@Composable
private fun PreviewCardVacancyItemShimmer() {
    DefaultPreview {
        CardVacancyItemShimmer(
            Modifier,
            rememberShimmer(shimmerBounds = ShimmerBounds.Custom),
        )
    }
}