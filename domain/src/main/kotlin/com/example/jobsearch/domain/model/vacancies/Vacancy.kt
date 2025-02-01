package com.example.jobsearch.domain.model.vacancies

import androidx.compose.runtime.Immutable
import java.time.LocalDate

@Immutable
data class Vacancy(
    val id: String = "",
    val lookingNumber: Int? = null,
    val title: String = "",
    val address: Address = Address(),
    val company: String = "",
    val experience: Experience = Experience(),
    val publishedDate: LocalDate = LocalDate.now(),
    val isFavorite: Boolean = false,
    val salary: Salary = Salary(),
    val schedules: List<String> = listOf(),
    val appliedNumber: Int? = null,
    val description: String = "",
    val responsibilities: String = "",
    val questions: List<String> = listOf(),
)