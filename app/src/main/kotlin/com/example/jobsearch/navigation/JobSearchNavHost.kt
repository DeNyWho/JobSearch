package com.example.jobsearch.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.jobsearch.feature.auth.navigation.authScreen
import com.example.jobsearch.feature.detail.navigation.detailScreen
import com.example.jobsearch.feature.favourite.navigation.favouriteScreen
import com.example.jobsearch.feature.messages.navigation.messagesScreen
import com.example.jobsearch.feature.profile.navigation.profileScreen
import com.example.jobsearch.feature.responses.navigation.responsesScreen
import com.example.jobsearch.feature.search.navigation.SEARCH_ROUTE
import com.example.jobsearch.feature.search.navigation.searchScreen
import com.example.jobsearch.ui.JobSearchAppState

@Composable
fun JobSearchNavHost(
    appState: JobSearchAppState,
    modifier: Modifier = Modifier,
    startDestination: String = SEARCH_ROUTE,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        authScreen()
        searchScreen()
        favouriteScreen()
        detailScreen()
        messagesScreen()
        responsesScreen()
        profileScreen()
    }
}