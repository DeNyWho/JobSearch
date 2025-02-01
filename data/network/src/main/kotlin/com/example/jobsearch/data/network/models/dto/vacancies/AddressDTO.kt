package com.example.jobsearch.data.network.models.dto.vacancies

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressDTO(
    @SerialName("town")
    val town: String = "",
    @SerialName("street")
    val street: String = "",
    @SerialName("house")
    val house: String = "",
)