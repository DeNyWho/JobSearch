package com.example.jobsearch.domain.model.vacancies

import androidx.compose.runtime.Immutable

@Immutable
data class Salary(
    val full: String = "",
    val short: String? = null,
)