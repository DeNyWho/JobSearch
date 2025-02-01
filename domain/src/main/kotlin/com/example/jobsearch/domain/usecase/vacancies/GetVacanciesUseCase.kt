package com.example.jobsearch.domain.usecase.vacancies

import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.repository.vacancies.VacanciesRepository
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.coroutines.flow.Flow

class GetVacanciesUseCase(private val vacanciesRepository: VacanciesRepository) {
    operator fun invoke(): Flow<StateListWrapper<Vacancy>> {
        return vacanciesRepository.getVacancies()
    }
}