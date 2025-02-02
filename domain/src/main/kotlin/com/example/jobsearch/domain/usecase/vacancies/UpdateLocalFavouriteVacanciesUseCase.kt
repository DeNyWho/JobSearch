package com.example.jobsearch.domain.usecase.vacancies

import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.repository.vacancies.VacanciesLocalRepository

class UpdateLocalFavouriteVacanciesUseCase(private val vacanciesLocalRepository: VacanciesLocalRepository) {
    suspend operator fun invoke(vacancy: Vacancy): Vacancy? {
        return vacanciesLocalRepository.updateFavouriteVacancy(vacancy)
    }
}