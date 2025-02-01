@file:UseSerializers(LocalDateSerializer::class)
package com.example.jobsearch.data.network.models.dto.vacancies

import com.example.jobsearch.core.common.serializer.LocalDateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.time.LocalDate

@Serializable
data class VacancyDTO(
    @SerialName("id")
    val id: String,
    @SerialName("lookingNumber")
    val lookingNumber: Int?,
    @SerialName("title")
    val title: String,
    @SerialName("address")
    val address: AddressDTO,
    @SerialName("company")
    val company: String,
    @SerialName("experience")
    val experience: ExperienceDTO,
    @SerialName("publishedDate")
    val publishedDate: LocalDate,
    @SerialName("isFavorite")
    val isFavorite: Boolean,
    @SerialName("salary")
    val salary: SalaryDTO,
    @SerialName("schedules")
    val schedules: List<String>,
    @SerialName("appliedNumber")
    val appliedNumber: Int?,
    @SerialName("description")
    val description: String,
    @SerialName("responsibilities")
    val responsibilities: String,
    @SerialName("questions")
    val questions: List<String>,
)