package com.example.jobsearch.feature.favourite.component.top

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jobsearch.core.uikit.theme.basicGreyThird
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.feature.favourite.R

@Composable
internal fun ComponentTop(
    modifier: Modifier = Modifier,
    contentState: StateListWrapper<Vacancy>,
) {
    val vacanciesSize = contentState.data.size

    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = stringResource(R.string.feature_favourite_section_top),
            style = MaterialTheme.typography.displayMedium,
            color = Color.White,
        )

        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = pluralStringResource(R.plurals.feature_favourite_section_top, vacanciesSize, vacanciesSize),
            style = MaterialTheme.typography.bodyLarge,
            color = basicGreyThird,
        )
    }
}