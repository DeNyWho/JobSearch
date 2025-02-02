package com.example.jobsearch.domain.repository.vacancies

import com.example.jobsearch.domain.model.vacancies.Vacancy

interface VacanciesLocalRepository {
    suspend fun insertVacancy(vacancy: Vacancy): Long
    suspend fun updateFavouriteVacancy(vacancy: Vacancy): Vacancy?
}