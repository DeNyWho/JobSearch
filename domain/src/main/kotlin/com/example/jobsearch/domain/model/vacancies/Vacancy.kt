package com.example.jobsearch.domain.model.vacancies

import androidx.compose.runtime.Immutable
import java.time.LocalDate

@Immutable
data class Vacancy(
    val id: String,
    val lookingNumber: Int?,
    val title: String,
    val address: Address,
    val company: String,
    val experience: Experience,
    val publishedDate: LocalDate,
    val isFavorite: Boolean,
    val salary: Salary,
    val schedules: List<String>,
    val appliedNumber: Int?,
    val description: String,
    val responsibilities: String,
)