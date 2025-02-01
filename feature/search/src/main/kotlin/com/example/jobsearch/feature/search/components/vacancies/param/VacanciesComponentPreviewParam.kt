package com.example.jobsearch.feature.search.components.vacancies.param

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.jobsearch.core.uikit.param.GlobalParams.Offers
import com.example.jobsearch.core.uikit.param.GlobalParams.Vacancies
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper

internal data class VacanciesComponentPreviewParam(
    val contentState: StateListWrapper<Vacancy>,
)

internal class VacanciesComponentProvider:
    PreviewParameterProvider<VacanciesComponentPreviewParam> {
    override val count: Int
        get() = super.count
    override val values: Sequence<VacanciesComponentPreviewParam>
        get() = listOf(
            VacanciesComponentPreviewParam(
                contentState = StateListWrapper(data = Vacancies),
            )
        ).asSequence()
}