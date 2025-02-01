package com.example.jobsearch.data.network.models.dto.vacancies

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SalaryDTO(
    @SerialName("full")
    val full: String = "",
    @SerialName("short")
    val short: String? = null,
)