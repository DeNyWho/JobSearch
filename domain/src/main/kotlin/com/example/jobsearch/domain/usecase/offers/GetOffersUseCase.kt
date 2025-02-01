package com.example.jobsearch.domain.usecase.offers

import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.repository.offers.OffersRepository
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.coroutines.flow.Flow

class GetOffersUseCase(private val offersRepository: OffersRepository) {
    operator fun invoke(): Flow<StateListWrapper<Offer>> {
        return offersRepository.getOffers()
    }
}