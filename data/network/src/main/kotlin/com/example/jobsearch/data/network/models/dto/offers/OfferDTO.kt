package com.example.jobsearch.data.network.models.dto.offers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OfferDTO(
    @SerialName("id")
    val id: String?,
    @SerialName("title")
    val title: String,
    @SerialName("button")
    val button: ButtonDTO? = null,
    @SerialName("link")
    val link: String,
)