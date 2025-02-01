package com.example.jobsearch.data.network.mappers.offers

import com.example.jobsearch.data.network.models.dto.offers.ButtonDTO
import com.example.jobsearch.data.network.models.dto.offers.OfferDTO
import com.example.jobsearch.domain.model.offers.Button
import com.example.jobsearch.domain.model.offers.Offer

fun OfferDTO.toOffer(): Offer = Offer(
    id = id,
    title = title,
    button = button?.toButton(),
    link = link,
)

fun ButtonDTO.toButton(): Button = Button(
    text = text,
)