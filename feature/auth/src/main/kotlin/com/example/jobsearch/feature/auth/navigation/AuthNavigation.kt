package com.example.jobsearch.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.jobsearch.feature.auth.AuthScreen

const val AUTH_ROUTE = "auth_route"

fun NavController.navigateToAuth(navOptions: NavOptions) = navigate(AUTH_ROUTE, navOptions)

fun NavGraphBuilder.authScreen() {
    composable(
        route = AUTH_ROUTE
    ) {
        AuthScreen()
    }
}