package com.example.jobsearch.feature.search.components.filter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.unit.dp
import com.example.jobsearch.core.uikit.icon.JobSearchIcons
import com.example.jobsearch.core.uikit.theme.blue
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.feature.home.R

@Composable
internal fun FilterComponent(
    modifier: Modifier = Modifier,
    contentState: StateListWrapper<Vacancy>,
) {
    val vacanciesSize = contentState.data.size

    Row(
        modifier = modifier,
    ) {
        Text(
            text = pluralStringResource(R.plurals.feature_search_section_filter_vacancies, vacanciesSize, vacanciesSize),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )

        Spacer(Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = pluralStringResource(R.plurals.feature_search_section_filter_vacancies, vacanciesSize, vacanciesSize),
                style = MaterialTheme.typography.bodyLarge,
                color = blue,
            )

            Image(
                modifier = Modifier.size(16.dp),
                painter = painterResource(JobSearchIcons.sort),
                contentDescription = "Filter",
            )
        }
    }
}