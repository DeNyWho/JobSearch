package com.example.jobsearch.data.network.service

import com.example.jobsearch.data.network.BuildConfig
import com.example.jobsearch.data.network.api.ApiEndpoints
import com.example.jobsearch.data.network.models.dto.offers.OfferDTO
import com.example.jobsearch.data.network.safeApiCall
import com.example.jobsearch.domain.model.common.request.Resource
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.HttpMethod
import io.ktor.http.encodedPath
import javax.inject.Inject

class JobService @Inject constructor(private val client: HttpClient) {
    suspend fun getJob(): Resource<List<OfferDTO>> {
        val request = HttpRequestBuilder().apply {
            method = HttpMethod.Get
            url {
                encodedPath = "${ApiEndpoints.MOCK}${BuildConfig.url_id}&export=${BuildConfig.url_exported}"
            }
        }

        return safeApiCall<List<OfferDTO>>(client, request)
    }
}