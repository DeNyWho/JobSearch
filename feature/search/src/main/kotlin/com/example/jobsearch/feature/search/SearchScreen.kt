package com.example.jobsearch.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobsearch.core.uikit.theme.basicBlack
import com.example.jobsearch.core.uikit.utils.DefaultPreview
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper

@Composable
internal fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
) {
    SearchUI(
        offers = viewModel.offers.value,
        vacancies = viewModel.vacancies.value,
    )
}

@Composable
private fun SearchUI(
    offers: StateListWrapper<Offer>,
    vacancies: StateListWrapper<Vacancy>,
) {
    val lazyColumnState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        state = lazyColumnState,
    ) {

    }
}

//@PreviewScreenSizes
//@Composable
//private fun PreviewSearchUI() {
//    DefaultPreview {
//        SearchUI(viewModel.offers.value, viewModel.vacancies.value)
//    }
//}
