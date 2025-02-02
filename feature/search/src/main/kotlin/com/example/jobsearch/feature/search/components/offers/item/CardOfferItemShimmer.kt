package com.example.jobsearch.feature.search.components.offers.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jobsearch.core.uikit.utils.DefaultPreview
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
private fun CardOfferItemShimmer(
    shimmerInstance: Shimmer,
    width: Dp = CardOfferItemDefaults.Width.Default,
    height: Dp = CardOfferItemDefaults.Height.Default,
) {
    Card(
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .shimmer(shimmerInstance)
            .width(width)
            .height(height),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        shape = MaterialTheme.shapes.small,
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 8.dp)
                .fillMaxSize(),
        ) {
            Card(
                modifier = Modifier
                    .size(32.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onSurfaceVariant,
                ),
                shape = CircleShape,
            ) { }

            Column(
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
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
            }
        }
    }
}

internal fun LazyListScope.showCardOfferItemShimmer(
    shimmerInstance: Shimmer,
    count: Int = 4,
) {
    items(count) {
        CardOfferItemShimmer(
            shimmerInstance = shimmerInstance,
        )
    }
}

@Preview
@Composable
private fun PreviewCardOfferItemShimmer() {
    DefaultPreview {
        CardOfferItemShimmer(
            rememberShimmer(shimmerBounds = ShimmerBounds.Custom),
        )
    }
}