package com.example.jobsearch.data.source.repository.vacancies

import com.example.jobsearch.data.network.mappers.vacancies.toVacancy
import com.example.jobsearch.data.network.service.JobService
import com.example.jobsearch.domain.model.common.request.Resource
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.repository.vacancies.VacanciesRepository
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class VacanciesRepositoryImpl(
    private val jobService: JobService,
): VacanciesRepository {
    override fun getVacancies(): Flow<StateListWrapper<Vacancy>> {
        return flow {
            emit(StateListWrapper.loading())

            val state = when(val vacanciesResult = jobService.getJob()) {
                is Resource.Success -> {
                    val data = vacanciesResult.data.vacancies.map { it.toVacancy() }.toImmutableList()
                    StateListWrapper(data)
                }
                is Resource.Error -> {
                    StateListWrapper(error = vacanciesResult.error)
                }
                is Resource.Loading -> {
                    StateListWrapper.loading()
                }
            }

            emit(state)
        }.flowOn(Dispatchers.IO)
    }
}