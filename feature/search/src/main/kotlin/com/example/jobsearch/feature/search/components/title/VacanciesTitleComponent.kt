package com.example.jobsearch.feature.search.components.title

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.feature.search.R
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
internal fun VacanciesTitleComponent(
    modifier: Modifier = Modifier,
    contentState: StateListWrapper<Vacancy>,
    shimmer: Shimmer = rememberShimmer(ShimmerBounds.View),
) {
    if(contentState.isLoading) {
        Box(
            modifier = modifier
                .shimmer(shimmer)
                .width(120.dp)
                .height(20.dp)
                .background(color = MaterialTheme.colorScheme.onSurfaceVariant),
        )
    } else {
        Text(
            modifier = modifier,
            text = stringResource(R.string.feature_search_section_vacancy_for_you_title),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}