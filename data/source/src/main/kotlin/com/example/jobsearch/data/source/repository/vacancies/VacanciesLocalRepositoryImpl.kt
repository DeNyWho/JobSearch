package com.example.jobsearch.data.source.repository.vacancies

import com.example.jobsearch.data.local.dao.vacancy.VacancyDao
import com.example.jobsearch.data.local.mappers.vacancy.toAddressEntity
import com.example.jobsearch.data.local.mappers.vacancy.toExperienceEntity
import com.example.jobsearch.data.local.mappers.vacancy.toSalaryEntity
import com.example.jobsearch.data.local.mappers.vacancy.toVacancy
import com.example.jobsearch.data.local.mappers.vacancy.toVacancyEntity
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.repository.vacancies.VacanciesLocalRepository

internal class VacanciesLocalRepositoryImpl(
    private val vacancyDao: VacancyDao,
): VacanciesLocalRepository {
    override suspend fun insertVacancy(vacancy: Vacancy): Long {
        val vacancyEntity = vacancy.toVacancyEntity()
        val addressEntity = vacancy.toAddressEntity()
        val salaryEntity = vacancy.toSalaryEntity()
        val experienceEntity = vacancy.toExperienceEntity()

        return vacancyDao.insertVacancy(
            vacancy = vacancyEntity,
            address = addressEntity,
            salary = salaryEntity,
            experience = experienceEntity,
        )
    }

    override suspend fun updateFavouriteVacancy(vacancy: Vacancy): Vacancy? {
        val localVacancy = vacancyDao.getVacancyById(vacancy.id)

        if (localVacancy == null) {
            insertVacancy(vacancy.copy(isFavorite = true))
        } else {
            vacancyDao.updateFavoriteStatus(vacancy.id)
        }

        return vacancyDao.getVacancyById(vacancy.id)?.toVacancy()
    }

}