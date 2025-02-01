package com.example.jobsearch.domain.repository.offers

import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.state.StateListWrapper
import kotlinx.coroutines.flow.Flow

interface OffersRepository {
    fun getOffers(): Flow<StateListWrapper<Offer>>
}