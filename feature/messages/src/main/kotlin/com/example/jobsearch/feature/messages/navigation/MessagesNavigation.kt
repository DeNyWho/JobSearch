package com.example.jobsearch.feature.messages.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.jobsearch.feature.messages.MessagesScreen

const val MESSAGES_ROUTE = "messages_route"

fun NavController.navigateToMessages(navOptions: NavOptions? = null) = navigate(MESSAGES_ROUTE, navOptions)

fun NavGraphBuilder.messagesScreen() {
    composable(
        route = MESSAGES_ROUTE,
    ) {
        MessagesScreen()
    }
}