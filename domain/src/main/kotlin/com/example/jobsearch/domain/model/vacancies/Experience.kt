package com.example.jobsearch.domain.model.vacancies

import androidx.compose.runtime.Immutable

@Immutable
data class Experience(
    val previewText: String,
    val text: String,
)