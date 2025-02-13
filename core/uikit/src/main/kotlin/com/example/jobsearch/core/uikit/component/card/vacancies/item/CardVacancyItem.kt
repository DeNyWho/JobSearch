package com.example.jobsearch.core.uikit.component.card.vacancies.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.jobsearch.core.uikit.R
import com.example.jobsearch.core.uikit.component.button.JobSearchButton
import com.example.jobsearch.core.uikit.component.card.vacancies.item.param.CardVacancyItemPreviewParam
import com.example.jobsearch.core.uikit.component.card.vacancies.item.param.CardVacancyItemProvider
import com.example.jobsearch.core.uikit.icon.JobSearchIcons
import com.example.jobsearch.core.uikit.theme.basicGreyThird
import com.example.jobsearch.core.uikit.theme.green
import com.example.jobsearch.core.uikit.utils.DefaultPreview
import com.example.jobsearch.domain.model.vacancies.Vacancy
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
internal fun CardVacancyItem(
    modifier: Modifier = Modifier,
    data: Vacancy,
    onFavouriteClick: (Vacancy) -> Unit = { },
    onCardClick: () -> Unit = { },
) {
    val formatter = DateTimeFormatter.ofPattern("dd MMMM", Locale("ru"))
    val lookingNumber = data.lookingNumber

    Card(
        modifier = modifier
            .clickable { onCardClick.invoke() }
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        shape = MaterialTheme.shapes.small,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Row {
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    if(lookingNumber != null) {
                        Text(
                            modifier = Modifier.padding(bottom = 12.dp),
                            text = pluralStringResource(R.plurals.core_uikit_vacancy_watch, lookingNumber, lookingNumber),
                            style = MaterialTheme.typography.bodyLarge,
                            color = green
                        )
                    }

                    Text(
                        text = data.title,
                        style = MaterialTheme.typography.headlineLarge,
                    )

                    Text(
                        modifier = Modifier.padding(top = 12.dp),
                        text = data.address.town,
                        style = MaterialTheme.typography.bodyLarge,
                    )

                    Row(
                        modifier = Modifier.padding(top = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text(
                            text = data.company,
                            style = MaterialTheme.typography.bodyLarge,
                        )

                        Image(
                            modifier = Modifier
                                .size(16.dp),
                            painter = painterResource(JobSearchIcons.check),
                            contentDescription = "Check",
                        )
                    }

                    Row(
                        modifier = Modifier.padding(top = 12.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Image(
                            modifier = Modifier
                                .size(16.dp),
                            painter = painterResource(JobSearchIcons.exp),
                            contentDescription = "exp",
                        )

                        Text(
                            text = data.experience.previewText,
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }

                    Text(
                        modifier = Modifier.padding(top = 12.dp),
                        text = "${stringResource(R.string.core_uikit_vacancy_published)} ${data.publishedDate.format(formatter)}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = basicGreyThird,
                    )
                }

                Image(
                    modifier = Modifier
                        .clickable {
                            onFavouriteClick.invoke(data)
                        }
                        .size(24.dp)
                        .align(Alignment.Top),
                    painter = if(data.isFavorite) painterResource(JobSearchIcons.heartFavourite) else painterResource(JobSearchIcons.heart),
                    contentDescription = "Favourite",
                )
            }

            JobSearchButton(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .pointerInput(Unit) { }
                    .fillMaxWidth(),
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                paddingValues = PaddingValues(vertical = 8.dp),
                shape = RoundedCornerShape(50.dp),
            ) {
                Text(
                    text = stringResource(R.string.core_uikit_vacancy_respond),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewCardVacancyItem(
    @PreviewParameter(CardVacancyItemProvider::class) param: CardVacancyItemPreviewParam,
) {
    DefaultPreview {
        CardVacancyItem(
            data = param.data,
        )
    }
}