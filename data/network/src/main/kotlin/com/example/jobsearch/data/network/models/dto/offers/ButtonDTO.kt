package com.example.jobsearch.data.network.models.dto.offers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ButtonDTO(
    @SerialName("text")
    val text: String = "",
)