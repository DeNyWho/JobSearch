package com.example.jobsearch.feature.responses.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.jobsearch.feature.responses.ResponsesScreen

const val RESPONSES_ROUTE = "responses_route"

fun NavController.navigateToResponses(navOptions: NavOptions? = null) = navigate(RESPONSES_ROUTE, navOptions)

fun NavGraphBuilder.responsesScreen() {
    composable(
        route = RESPONSES_ROUTE,
    ) {
        ResponsesScreen()
    }
}