package com.example.jobsearch.data.source.repository.vacancies

import com.example.jobsearch.data.local.dao.vacancy.VacancyDao
import com.example.jobsearch.data.network.mappers.vacancies.toVacancy
import com.example.jobsearch.data.network.service.JobService
import com.example.jobsearch.domain.model.common.request.Resource
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.repository.vacancies.VacanciesRepository
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class VacanciesRepositoryImpl(
    private val jobService: JobService,
    private val vacancyDao: VacancyDao,
): VacanciesRepository {
    override fun getVacancies(isForYou: Boolean): Flow<StateListWrapper<Vacancy>> {
        return flow {
            emit(StateListWrapper.loading())

            when (val vacanciesResult = jobService.getJob()) {
                is Resource.Success -> {
                    val remoteVacancies = vacanciesResult.data.vacancies.map { it.toVacancy() }

                    vacancyDao.getVacancies().collect { localVacancies ->
                        val vacanciesWithFavorites = remoteVacancies.map { vacancy ->
                            val localVacancy = localVacancies.find { it.vacancy.id == vacancy.id }
                            vacancy.copy(isFavorite = localVacancy?.vacancy?.isFavorite ?: false)
                        }

                        emit(StateListWrapper(if (isForYou) vacanciesWithFavorites.take(3) else vacanciesWithFavorites))
                    }
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