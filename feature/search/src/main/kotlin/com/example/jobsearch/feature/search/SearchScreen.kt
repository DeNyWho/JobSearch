package com.example.jobsearch.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobsearch.core.uikit.component.card.vacancies.VacanciesComponent
import com.example.jobsearch.core.uikit.utils.DefaultPreview
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.feature.search.components.filter.FilterComponent
import com.example.jobsearch.feature.search.components.more.MoreComponent
import com.example.jobsearch.feature.search.components.offers.OffersComponent
import com.example.jobsearch.feature.search.components.search.SearchComponent
import com.example.jobsearch.feature.search.components.title.VacanciesTitleComponent
import com.example.jobsearch.feature.search.model.state.SearchUiState
import com.example.jobsearch.feature.search.model.ui.SearchUiScreen
import com.example.jobsearch.feature.search.param.SearchContentPreviewParam
import com.example.jobsearch.feature.search.param.SearchContentProvider

@Composable
internal fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val offers by viewModel.offers.collectAsState()
    val vacancies by viewModel.vacancies.collectAsState()

    SearchContent(
        uiState,
        offers = offers,
        vacancies = vacancies,
        onMoreClick = {
            viewModel.changeUiState()
        },
        onBackClick = {
            viewModel.changeUiState()
        },
        onFavouriteClick = { vacancy ->
            viewModel.changeFavourite(vacancy)
        },
    )
}

@Composable
private fun SearchContent(
    uiState: SearchUiState,
    offers: StateListWrapper<Offer>,
    vacancies: StateListWrapper<Vacancy>,
    onMoreClick: () -> Unit = { },
    onBackClick: () -> Unit = { },
    onFavouriteClick: (Vacancy) -> Unit = { },
) {
    Column {
        when (uiState.uiScreen) {
            SearchUiScreen.ForYou -> {
                SearchUIForYou(
                    offers = offers,
                    vacancies = vacancies,
                    uiState = uiState,
                    onMoreClick = onMoreClick,
                    onFavouriteClick = onFavouriteClick,
                )
            }
            SearchUiScreen.All -> {
                SearchUIAll(
                    vacancies = vacancies,
                    uiState = uiState,
                    onBackClick = onBackClick,
                    onFavouriteClick = onFavouriteClick,
                )
            }
        }
    }
}

@Composable
private fun SearchUIForYou(
    offers: StateListWrapper<Offer>,
    vacancies: StateListWrapper<Vacancy>,
    uiState: SearchUiState,
    onMoreClick: () -> Unit = { },
    onFavouriteClick: (Vacancy) -> Unit = { },
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            SearchComponent(
                uiState = uiState,
                modifier = Modifier
                    .padding(16.dp),
                onBackClick = { },
            )
        }

        item {
            OffersComponent(
                contentState = offers,
            )
        }

        item {
            VacanciesTitleComponent(
                modifier = Modifier.padding(start = 16.dp, top = 32.dp),
                contentState = vacancies,
            )
        }

        item {
            VacanciesComponent(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                contentState = vacancies,
                onFavouriteClick = onFavouriteClick,
                isForYou = true,
            )
        }

        item {
            MoreComponent(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp),
                contentState = vacancies,
                onClick = onMoreClick,
            )
        }
    }
}

@Composable
private fun SearchUIAll(
    vacancies: StateListWrapper<Vacancy>,
    uiState: SearchUiState,
    onBackClick: () -> Unit,
    onFavouriteClick: (Vacancy) -> Unit = { },
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        SearchComponent(
            uiState = uiState,
            modifier = Modifier
                .padding(16.dp),
            onBackClick = onBackClick,
        )

        LazyColumn {
            item {
                FilterComponent(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    contentState = vacancies,
                )
            }

            item {
                VacanciesComponent(
                    modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp),
                    contentState = vacancies,
                    onFavouriteClick = onFavouriteClick,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSearchContent(
    @PreviewParameter(SearchContentProvider::class) param: SearchContentPreviewParam,
) {
    DefaultPreview {
        SearchContent(
            uiState = param.uiState,
            offers = param.offers,
            vacancies = param.vacancies,
        )
    }
}
