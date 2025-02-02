package com.example.jobsearch.domain.usecase.vacancies

import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.repository.vacancies.VacanciesLocalRepository
import com.example.jobsearch.domain.repository.vacancies.VacanciesRepository
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.coroutines.flow.Flow

class UpdateLocalFavouriteVacanciesUseCase(private val vacanciesLocalRepository: VacanciesLocalRepository) {
    suspend operator fun invoke(vacancyId: String): Vacancy? {
        return vacanciesLocalRepository.updateFavouriteVacancy(vacancyId)
    }
}