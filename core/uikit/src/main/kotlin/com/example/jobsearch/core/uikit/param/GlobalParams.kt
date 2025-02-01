package com.example.jobsearch.core.uikit.param

import com.example.jobsearch.domain.model.offers.Button
import com.example.jobsearch.domain.model.offers.Offer
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import java.util.UUID

object GlobalParams {
    val OfferSingle: Offer = Offer(
        id = "level_up_resume",
        title = "Поднять резюме в поиске",
        button = Button(
            text = "Поднять",
        ),
        link = "https://hh.ru/mentors?from\u003dfooter_new\u0026hhtmFromLabel\u003dfooter_new\u0026hhtmFrom\u003dmain\u0026purposeId\u003d1",
    )

    val Offers: ImmutableList<Offer> = listOf(OfferSingle, OfferSingle.copy(id = UUID.randomUUID().toString()), OfferSingle.copy(id = UUID.randomUUID().toString())).toImmutableList()
}