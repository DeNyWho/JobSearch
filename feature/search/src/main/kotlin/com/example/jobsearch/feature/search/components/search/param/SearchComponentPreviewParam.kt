package com.example.jobsearch.feature.search.components.search.param

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.jobsearch.feature.search.model.state.SearchUiState
import com.example.jobsearch.feature.search.model.ui.SearchUiScreen

internal data class SearchComponentPreviewParam(
    val modifier: Modifier = Modifier,
    val uiState: SearchUiState,
    val onBackClick: () -> Unit = { },
)

internal class SearchComponentProvider:
    PreviewParameterProvider<SearchComponentPreviewParam> {
    override val count: Int
        get() = super.count
    override val values: Sequence<SearchComponentPreviewParam>
        get() = listOf(
            SearchComponentPreviewParam(
                modifier = Modifier
                    .padding(16.dp),
                uiState = SearchUiState(SearchUiScreen.ForYou),
            ),
            SearchComponentPreviewParam(
                modifier = Modifier
                    .padding(16.dp),
                uiState = SearchUiState(SearchUiScreen.All),
            )
        ).asSequence()
}