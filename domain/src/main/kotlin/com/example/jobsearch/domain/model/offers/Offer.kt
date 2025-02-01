package com.example.jobsearch.domain.model.offers

import androidx.compose.runtime.Immutable

@Immutable
data class Offer(
    val id: String?,
    val title: String,
    val button: Button? = null,
    val link: String,
)