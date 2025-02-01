package com.example.jobsearch.data.source.repository.offers

import com.example.jobsearch.data.network.mappers.offers.toOffer
import com.example.jobsearch.data.network.service.JobService
import com.example.jobsearch.domain.model.common.request.Resource
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.repository.offers.OffersRepository
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class OffersRepositoryImpl(
    private val jobService: JobService,
): OffersRepository {
    override fun getOffers(): Flow<StateListWrapper<Offer>> {
        return flow {
            emit(StateListWrapper.loading())

            val state = when(val offersResult = jobService.getJob()) {
                is Resource.Success -> {
                    val data = offersResult.data.offers.map { it.toOffer() }.toImmutableList()
                    StateListWrapper(data)
                }
                is Resource.Error -> {
                    StateListWrapper(error = offersResult.error)
                }
                is Resource.Loading -> {
                    StateListWrapper.loading()
                }
            }

            emit(state)
        }.flowOn(Dispatchers.IO)
    }
}