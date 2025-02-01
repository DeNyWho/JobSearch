package com.example.jobsearch.data.network.models.dto.job

import com.example.jobsearch.data.network.models.dto.offers.OfferDTO
import com.example.jobsearch.data.network.models.dto.vacancies.VacancyDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobDTO(
    @SerialName("offers")
    val offers: List<OfferDTO>,
    @SerialName("vacancies")
    val vacancies: List<VacancyDTO>,
)