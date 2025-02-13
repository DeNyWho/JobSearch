package com.example.jobsearch.feature.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.jobsearch.feature.search.SearchScreen

const val SEARCH_ROUTE = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptions) = navigate(SEARCH_ROUTE, navOptions)

fun NavGraphBuilder.searchScreen(
    onVacancyClick: () -> Unit,
) {
    composable(
        route = SEARCH_ROUTE
    ) {
        SearchScreen(
            onVacancyClick = onVacancyClick,
        )
    }
}