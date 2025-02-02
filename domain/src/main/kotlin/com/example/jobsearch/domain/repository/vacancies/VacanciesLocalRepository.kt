package com.example.jobsearch.domain.repository.vacancies

import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.coroutines.flow.Flow

interface VacanciesLocalRepository {
    suspend fun insertVacancy(vacancy: Vacancy): Long
    suspend fun updateFavouriteVacancy(vacancy: Vacancy): Vacancy?
    suspend fun getFavouriteVacancies(): Flow<StateListWrapper<Vacancy>>
}