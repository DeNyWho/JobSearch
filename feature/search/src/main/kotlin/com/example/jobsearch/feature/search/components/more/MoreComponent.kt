package com.example.jobsearch.feature.search.components.more

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
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
            text = "${stringResource(R.string.feature_search_section_button)} ${pluralStringResource(com.example.jobsearch.core.uikit.R.plurals.core_uikit_vacancies_count, vacanciesSize, vacanciesSize)}",
            style = MaterialTheme.typography.labelLarge,
        )
    }
}