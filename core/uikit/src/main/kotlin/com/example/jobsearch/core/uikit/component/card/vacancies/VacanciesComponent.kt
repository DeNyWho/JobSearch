package com.example.jobsearch.core.uikit.component.card.vacancies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.jobsearch.core.uikit.component.card.vacancies.item.CardVacancyItem
import com.example.jobsearch.core.uikit.component.card.vacancies.item.CardVacancyItemDefaults
import com.example.jobsearch.core.uikit.component.card.vacancies.param.VacanciesComponentPreviewParam
import com.example.jobsearch.core.uikit.component.card.vacancies.param.VacanciesComponentProvider
import com.example.jobsearch.core.uikit.utils.DefaultPreview
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper

@Composable
fun VacanciesComponent(
    modifier: Modifier = Modifier,
    contentState: StateListWrapper<Vacancy>,
    contentArrangement: Arrangement.Vertical = CardVacancyItemDefaults.VerticalArrangement.ForYou,
) {
    Column(
        modifier = modifier,
        verticalArrangement = contentArrangement,
    ) {
        if (contentState.isLoading) {
            // Loading state handling
        } else {
            contentState.data.forEach { vacancy ->
                CardVacancyItem(
                    data = vacancy,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewVacanciesComponent(
    @PreviewParameter(VacanciesComponentProvider::class) param: VacanciesComponentPreviewParam,
) {
    DefaultPreview {
        VacanciesComponent(
            contentState = param.contentState,
        )
    }
}