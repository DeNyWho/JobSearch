package com.example.jobsearch.feature.search.components.offers.item.param

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import com.example.jobsearch.core.uikit.param.GlobalParams
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.feature.search.components.offers.item.CardOfferItemDefaults

internal data class CardOfferItemPreviewParam(
    val data: Offer,
    val width: Dp = CardOfferItemDefaults.Width.Default,
    val height: Dp = CardOfferItemDefaults.Height.Default,
)

internal class CardOfferItemProvider:
    PreviewParameterProvider<CardOfferItemPreviewParam> {
    override val count: Int
        get() = super.count
    override val values: Sequence<CardOfferItemPreviewParam>
        get() = listOf(
            CardOfferItemPreviewParam(
                data = GlobalParams.OfferSingle,
            )
        ).asSequence()
}