package com.example.jobsearch.domain.state

import com.example.jobsearch.domain.model.common.request.ApiError
import kotlinx.collections.immutable.persistentListOf

data class StateListWrapper<T>(
    val data: List<T> = persistentListOf(),
    val isLoading: Boolean = false,
    val error: ApiError? = null,
) {
    companion object {
        inline fun <reified T> loading(): StateListWrapper<T> {
            return StateListWrapper(isLoading = true)
        }
    }
}
