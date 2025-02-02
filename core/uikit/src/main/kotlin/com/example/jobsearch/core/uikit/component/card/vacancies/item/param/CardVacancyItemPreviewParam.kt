package com.example.jobsearch.core.uikit.component.card.vacancies.item.param

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.jobsearch.core.uikit.param.GlobalParams
import com.example.jobsearch.domain.model.vacancies.Vacancy

internal data class CardVacancyItemPreviewParam(
    val data: Vacancy,
)

internal class CardVacancyItemProvider:
    PreviewParameterProvider<CardVacancyItemPreviewParam> {
    override val count: Int
        get() = super.count
    override val values: Sequence<CardVacancyItemPreviewParam>
        get() = listOf(
            CardVacancyItemPreviewParam(
                data = GlobalParams.VacancySingle,
            )
        ).asSequence()
}