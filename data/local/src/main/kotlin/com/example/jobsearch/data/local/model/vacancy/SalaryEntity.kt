package com.example.jobsearch.data.local.model.vacancy

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "vacancy_salary",
    foreignKeys = [
        ForeignKey(
            entity = VacancyEntity::class,
            parentColumns = ["id"],
            childColumns = ["vacancyId"],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class SalaryEntity(
    @PrimaryKey val vacancyId: String,
    val full: String,
    val short: String?
)