package com.example.jobsearch.feature.search.param

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.jobsearch.core.uikit.param.GlobalParams.Offers
import com.example.jobsearch.core.uikit.param.GlobalParams.Vacancies
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.feature.search.model.state.SearchUiState
import com.example.jobsearch.feature.search.model.ui.SearchUiScreen
import kotlinx.collections.immutable.toImmutableList

internal data class SearchContentPreviewParam(
    val uiState: SearchUiState,
    val offers: StateListWrapper<Offer>,
    val vacancies: StateListWrapper<Vacancy>,
    val vacanciesForYou: StateListWrapper<Vacancy>,
)

internal class SearchContentProvider:
    PreviewParameterProvider<SearchContentPreviewParam> {
    override val count: Int
        get() = super.count
    override val values: Sequence<SearchContentPreviewParam>
        get() = listOf(
            SearchContentPreviewParam(
                uiState = SearchUiState(uiScreen = SearchUiScreen.ForYou),
                offers = StateListWrapper(data = Offers),
                vacancies = StateListWrapper(data = Vacancies),
                vacanciesForYou = StateListWrapper(data = Vacancies.take(3).toImmutableList()),
            ),
            SearchContentPreviewParam(
                uiState = SearchUiState(uiScreen = SearchUiScreen.All),
                offers = StateListWrapper(data = Offers),
                vacancies = StateListWrapper(data = Vacancies),
                vacanciesForYou = StateListWrapper(data = Vacancies.toImmutableList()),
            )
        ).asSequence()
}