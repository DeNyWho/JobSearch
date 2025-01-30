package com.example.jobsearch.navigation

import androidx.annotation.DrawableRes
import com.example.jobsearch.R
import com.example.jobsearch.core.uikit.icon.JobSearchIcons

enum class TopLevelDestination(
    @DrawableRes val icon: Int,
    val iconTextId: Int,
) {
    SEARCH(
        icon = JobSearchIcons.search,
        iconTextId = R.string.navigation_bar_search_title,
    ),
    FAVOURITE(
        icon = JobSearchIcons.heartNovistigation,
        iconTextId = R.string.navigation_bar_favourite_title,
    ),
    RESPONSE(
        icon = JobSearchIcons.response,
        iconTextId = R.string.navigation_bar_response_title,
    ),
    MESSAGES(
        icon = JobSearchIcons.messages,
        iconTextId = R.string.navigation_bar_messages_title,
    ),
    PROFILE(
        icon = JobSearchIcons.profile,
        iconTextId = R.string.navigation_bar_profile_title,
    ),
}