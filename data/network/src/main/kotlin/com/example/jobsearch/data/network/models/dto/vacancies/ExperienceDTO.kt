package com.example.jobsearch.data.network.models.dto.vacancies

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExperienceDTO(
    @SerialName("previewText")
    val previewText: String,
    @SerialName("text")
    val text: String,
)