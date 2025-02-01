package com.example.jobsearch.feature.search.components.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobsearch.core.uikit.icon.JobSearchIcons
import com.example.jobsearch.core.uikit.theme.basicGreyFourth
import com.example.jobsearch.core.uikit.theme.basicGreySecond
import com.example.jobsearch.feature.home.R
import com.example.jobsearch.feature.search.model.state.SearchUiState
import com.example.jobsearch.feature.search.model.ui.SearchUiScreen

@Composable
internal fun SearchComponent(
    modifier: Modifier = Modifier,
    uiState: SearchUiState,
    onBackClick: () -> Unit = { },
) {
    Row(
        modifier = modifier
            .height(40.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Card(
            modifier = Modifier
                .weight(1f),
            colors = CardDefaults.cardColors(
                containerColor = basicGreySecond,
            ),
            shape = MaterialTheme.shapes.small,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                when(uiState.uiScreen) {
                    SearchUiScreen.All -> {
                        Image(
                            modifier = Modifier
                                .clickable {
                                    onBackClick.invoke()
                                }
                                .fillMaxHeight(),
                            painter = painterResource(JobSearchIcons.leftArrow),
                            contentDescription = "back",
                        )
                    }
                    SearchUiScreen.ForYou -> {
                        Image(
                            modifier = Modifier
                                .fillMaxHeight(),
                            painter = painterResource(JobSearchIcons.search),
                            contentDescription = "back",
                        )
                    }
                }

                Text(
                    text = if(uiState.uiScreen == SearchUiScreen.ForYou)
                        stringResource(R.string.feature_search_section_search_for_you)
                    else stringResource(R.string.feature_search_section_search_all),
                    style = MaterialTheme.typography.bodyLarge,
                    color = basicGreyFourth,
                )
            }
        }
        Card(
            modifier = Modifier
                .size(40.dp),
            colors = CardDefaults.cardColors(
                containerColor = basicGreySecond,
            ),
            shape = MaterialTheme.shapes.small,
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(16.dp),
                    painter = painterResource(JobSearchIcons.filter),
                    contentDescription = "filter",
                )
            }
        }
    }
}