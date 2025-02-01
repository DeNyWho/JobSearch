package com.example.jobsearch.data.network.service

import com.example.jobsearch.data.network.BuildConfig
import com.example.jobsearch.data.network.api.ApiEndpoints
import com.example.jobsearch.data.network.models.dto.job.JobDTO
import com.example.jobsearch.data.network.safeApiCall
import com.example.jobsearch.domain.model.common.request.Resource
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import javax.inject.Inject

class JobService @Inject constructor(private val client: HttpClient) {
    suspend fun getJob(): Resource<JobDTO> {
        val request = HttpRequestBuilder().apply {
            method = HttpMethod.Get

            headers {
                contentType(ContentType.Application.OctetStream)
            }
            url {
                encodedPath = "${ApiEndpoints.MOCK}${BuildConfig.url_id}&export=${BuildConfig.url_exported}"
            }
        }

        return safeApiCall<JobDTO>(client, request)
    }
}