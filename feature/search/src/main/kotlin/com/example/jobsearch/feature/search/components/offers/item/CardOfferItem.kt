package com.example.jobsearch.feature.search.components.offers.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jobsearch.core.uikit.theme.darkBlue
import com.example.jobsearch.core.uikit.theme.green
import com.example.jobsearch.core.uikit.utils.DefaultPreview
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.feature.search.components.offers.item.param.CardOfferItemPreviewParam
import com.example.jobsearch.feature.search.components.offers.item.param.CardOfferItemProvider

@Composable
internal fun CardOfferItem(
    data: Offer,
    width: Dp = CardOfferItemDefaults.Width.Default,
    height: Dp = CardOfferItemDefaults.Height.Default,
) {
    Card(
        modifier = Modifier
            .width(width)
            .height(height),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
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
                    containerColor = darkBlue,
                ),
                shape = CircleShape,
            ) {

            }

            Column(
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text(
                    text = data.title,
                    style = MaterialTheme.typography.headlineMedium,
                )

                if(data.button != null) {
                    Text(
                        text = data.button!!.text,
                        style = MaterialTheme.typography.bodyLarge,
                        color = green,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewCardOfferItem(
    @PreviewParameter(CardOfferItemProvider::class) param: CardOfferItemPreviewParam,
) {
    DefaultPreview {
        CardOfferItem(
            data = param.data,
            width = param.width,
            height = param.height,
        )
    }
}