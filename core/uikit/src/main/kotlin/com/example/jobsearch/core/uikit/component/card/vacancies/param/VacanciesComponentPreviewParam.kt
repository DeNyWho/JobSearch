package com.example.jobsearch.core.uikit.component.card.vacancies.param

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.jobsearch.core.uikit.param.GlobalParams.Vacancies
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.collections.immutable.toImmutableList

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
                contentState = StateListWrapper(data = Vacancies.take(3).toImmutableList()),
            ),
            VacanciesComponentPreviewParam(
                contentState = StateListWrapper.loading(),
            )
        ).asSequence()
}