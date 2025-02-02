package com.example.jobsearch.feature.search.components.more

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.unit.dp
import com.example.jobsearch.core.uikit.component.button.JobSearchButton
import com.example.jobsearch.core.uikit.theme.blue
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.feature.search.R

@Composable
internal fun MoreComponent(
    modifier: Modifier = Modifier,
    contentState: StateListWrapper<Vacancy>,
    onClick: () -> Unit,
) {
    val vacanciesSize = contentState.data.size

    JobSearchButton(
        modifier = modifier
            .fillMaxWidth(),
        contentColor = MaterialTheme.colorScheme.onPrimary,
        containerColor = blue,
        paddingValues = PaddingValues(vertical = 12.dp),
        onClick = onClick,
    ) {
        Text(
            text = pluralStringResource(R.plurals.feature_search_section_more_vacancies, vacanciesSize, vacanciesSize),
            style = MaterialTheme.typography.labelLarge,
        )
    }
}