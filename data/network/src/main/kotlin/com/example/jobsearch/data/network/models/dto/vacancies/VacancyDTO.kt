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
    val id: String = "",
    @SerialName("lookingNumber")
    val lookingNumber: Int? = null,
    @SerialName("title")
    val title: String = "",
    @SerialName("address")
    val address: AddressDTO = AddressDTO(),
    @SerialName("company")
    val company: String = "",
    @SerialName("experience")
    val experience: ExperienceDTO = ExperienceDTO(),
    @SerialName("publishedDate")
    val publishedDate: LocalDate = LocalDate.now(),
    @SerialName("isFavorite")
    val isFavorite: Boolean = false,
    @SerialName("salary")
    val salary: SalaryDTO = SalaryDTO(),
    @SerialName("schedules")
    val schedules: List<String> = listOf(),
    @SerialName("appliedNumber")
    val appliedNumber: Int? = null,
    @SerialName("description")
    val description: String = "",
    @SerialName("responsibilities")
    val responsibilities: String = "",
    @SerialName("questions")
    val questions: List<String> = listOf(),
)