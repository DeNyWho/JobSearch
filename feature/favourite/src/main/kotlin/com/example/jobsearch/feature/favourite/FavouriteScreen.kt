package com.example.jobsearch.feature.favourite

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
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.feature.favourite.component.top.ComponentTop
import com.example.jobsearch.feature.favourite.param.FavouriteContentPreviewParam
import com.example.jobsearch.feature.favourite.param.FavouriteContentProvider

@Composable
internal fun FavouriteScreen(
    viewModel: FavouriteViewModel = hiltViewModel(),
) {
    val vacancies by viewModel.vacancies.collectAsState()

    FavouriteContent(
        vacancies = vacancies,
        onFavouriteClick = { vacancy ->
            viewModel.changeFavourite(vacancy)
        }
    )
}

@Composable
private fun FavouriteContent(
    vacancies: StateListWrapper<Vacancy>,
    onFavouriteClick: (Vacancy) -> Unit = { },
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            ComponentTop(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                contentState = vacancies,
            )
        }

        item {
            VacanciesComponent(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                contentState = vacancies,
                onFavouriteClick = onFavouriteClick,
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSearchContent(
    @PreviewParameter(FavouriteContentProvider::class) param: FavouriteContentPreviewParam,
) {
    DefaultPreview {
        FavouriteContent(
            vacancies = param.vacancies,
        )
    }
}
