package com.example.jobsearch.domain.repository.vacancies

import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.coroutines.flow.Flow

interface VacanciesRepository {

    fun getVacancies(isForYou: Boolean): Flow<StateListWrapper<Vacancy>>
}