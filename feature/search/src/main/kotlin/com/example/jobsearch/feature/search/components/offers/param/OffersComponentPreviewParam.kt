package com.example.jobsearch.feature.search.components.offers.param

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import com.example.jobsearch.core.uikit.param.GlobalParams.Offers
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.feature.search.components.offers.item.CardOfferItemDefaults

internal data class OffersComponentPreviewParam(
    val contentState: StateListWrapper<Offer>,
    val width: Dp = CardOfferItemDefaults.Width.Default,
    val height: Dp = CardOfferItemDefaults.Height.Default,
)

internal class OffersComponentProvider:
    PreviewParameterProvider<OffersComponentPreviewParam> {
    override val count: Int
        get() = super.count
    override val values: Sequence<OffersComponentPreviewParam>
        get() = listOf(
            OffersComponentPreviewParam(
                contentState = StateListWrapper(data = Offers),
            )
        ).asSequence()
}