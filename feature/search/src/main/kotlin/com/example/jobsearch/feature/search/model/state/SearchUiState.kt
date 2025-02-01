package com.example.jobsearch.feature.search.model.state

import com.example.jobsearch.feature.search.model.ui.SearchUiScreen

internal data class SearchUiState(
    val uiScreen: SearchUiScreen = SearchUiScreen.ForYou,
)