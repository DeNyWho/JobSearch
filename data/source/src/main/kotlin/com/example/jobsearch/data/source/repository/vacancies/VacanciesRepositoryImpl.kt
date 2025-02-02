package com.example.jobsearch.data.source.repository.vacancies

import com.example.jobsearch.data.local.dao.vacancy.VacancyDao
import com.example.jobsearch.data.local.mappers.vacancy.toVacancy
import com.example.jobsearch.data.network.mappers.vacancies.toVacancy
import com.example.jobsearch.data.network.service.JobService
import com.example.jobsearch.domain.model.common.request.Resource
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.repository.vacancies.VacanciesLocalRepository
import com.example.jobsearch.domain.repository.vacancies.VacanciesRepository
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

internal class VacanciesRepositoryImpl(
    private val jobService: JobService,
    private val vacancyDao: VacancyDao,
): VacanciesRepository {
    override fun getVacancies(isForYou: Boolean): Flow<StateListWrapper<Vacancy>> {
        return flow {
            emit(StateListWrapper.loading())

            when (val vacanciesResult = jobService.getJob()) {
                is Resource.Success -> {
                    val data = if (isForYou) {
                        vacanciesResult.data.vacancies.map { it.toVacancy() }.take(2).toImmutableList()
                    } else {
                        vacanciesResult.data.vacancies.map { it.toVacancy() }.toImmutableList()
                    }

                    val localVacancies = vacancyDao.getVacancies().map {
                        it.toVacancy()
                    }

                    val vacanciesWithFavorites = data.map { vacancy ->
                        val localVacancy = localVacancies.find { it.id == vacancy.id }
                        vacancy.copy(isFavorite = localVacancy?.isFavorite ?: false)
                    }.toImmutableList()

                    emit(StateListWrapper(vacanciesWithFavorites))
                }
                is Resource.Error -> {
                    emit(StateListWrapper(error = vacanciesResult.error))
                }
                is Resource.Loading -> {
                    emit(StateListWrapper.loading())
                }
            }
        }.flowOn(Dispatchers.IO)
    }
}