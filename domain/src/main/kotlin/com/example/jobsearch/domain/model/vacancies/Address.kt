package com.example.jobsearch.domain.model.vacancies

import androidx.compose.runtime.Immutable

@Immutable
data class Address(
    val town: String = "",
    val street: String = "",
    val house: String = "",
)