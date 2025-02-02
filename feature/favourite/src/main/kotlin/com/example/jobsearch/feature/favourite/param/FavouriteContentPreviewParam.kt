package com.example.jobsearch.feature.favourite.param

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.jobsearch.core.uikit.param.GlobalParams.Vacancies
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper

internal data class FavouriteContentPreviewParam(
    val vacancies: StateListWrapper<Vacancy>,
)

internal class FavouriteContentProvider:
    PreviewParameterProvider<FavouriteContentPreviewParam> {
    override val count: Int
        get() = super.count
    override val values: Sequence<FavouriteContentPreviewParam>
        get() = listOf(
            FavouriteContentPreviewParam(
                vacancies = StateListWrapper(data = Vacancies),
            ),
        ).asSequence()
}