package com.example.jobsearch.data.local.model.vacancy

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.jobsearch.domain.model.vacancies.Address
import com.example.jobsearch.domain.model.vacancies.Experience
import java.time.LocalDate

@Entity("vacancy")
data class VacancyEntity(
    @PrimaryKey val id: String,
    val lookingNumber: Int?,
    val title: String,
    val company: String,
    val publishedDate: LocalDate,
    val isFavorite: Boolean,
    val schedules: List<String>,
    val appliedNumber: Int?,
    val description: String,
    val responsibilities: String,
)

data class VacancyWithDetails(
    @Embedded val vacancy: VacancyEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "vacancyId",
    )
    val address: AddressEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "vacancyId",
    )
    val experience: ExperienceEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "vacancyId",
    )
    val salary: SalaryEntity,
)