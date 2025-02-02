package com.example.jobsearch.domain.repository.vacancies

import com.example.jobsearch.domain.model.vacancies.Vacancy
import kotlinx.coroutines.flow.Flow

interface VacanciesLocalRepository {
    suspend fun insertVacancy(vacancy: Vacancy): Long
    suspend fun updateFavouriteVacancy(vacancyId: String): Vacancy?
}