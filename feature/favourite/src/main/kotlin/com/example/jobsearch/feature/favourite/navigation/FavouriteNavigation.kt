package com.example.jobsearch.feature.favourite.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.jobsearch.feature.favourite.FavouriteScreen

const val FAVOURITE_ROUTE = "favourite_route"

fun NavController.navigateToFavourite(navOptions: NavOptions) = navigate(FAVOURITE_ROUTE, navOptions)

fun NavGraphBuilder.favouriteScreen(
    onVacancyClick: () -> Unit,
) {
    composable(
        route = FAVOURITE_ROUTE
    ) {
        FavouriteScreen(
            onVacancyClick = onVacancyClick,
        )
    }
}