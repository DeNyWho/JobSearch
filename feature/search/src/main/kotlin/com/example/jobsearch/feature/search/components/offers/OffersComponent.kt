package com.example.jobsearch.feature.search.components.offers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jobsearch.core.uikit.utils.DefaultPreview
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.feature.search.components.offers.item.CardOfferItem
import com.example.jobsearch.feature.search.components.offers.item.CardOfferItemDefaults
import com.example.jobsearch.feature.search.components.offers.param.OffersComponentPreviewParam
import com.example.jobsearch.feature.search.components.offers.param.OffersComponentProvider
import java.util.UUID

@Composable
internal fun OffersComponent(
    modifier: Modifier = Modifier,
    offerItemWidth: Dp = CardOfferItemDefaults.Width.Default,
    offerItemHeight: Dp = CardOfferItemDefaults.Height.Default,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    contentState: StateListWrapper<Offer>,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        if(contentState.isLoading) {

        } else {
            items(
                contentState.data,
                key = { it.id ?: UUID.randomUUID().toString() }
            ) { offer ->
                CardOfferItem(
                    data = offer,
                    width = offerItemWidth,
                    height = offerItemHeight,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewOffersComponent(
    @PreviewParameter(OffersComponentProvider::class) param: OffersComponentPreviewParam,
) {
    DefaultPreview {
        OffersComponent(
            contentState = param.contentState,
        )
    }
}