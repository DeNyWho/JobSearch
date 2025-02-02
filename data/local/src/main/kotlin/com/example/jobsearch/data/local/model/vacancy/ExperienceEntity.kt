package com.example.jobsearch.data.local.model.vacancy

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "vacancy_experience",
    foreignKeys = [
        ForeignKey(
            entity = VacancyEntity::class,
            parentColumns = ["id"],
            childColumns = ["vacancyId"],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class ExperienceEntity(
    @PrimaryKey val vacancyId: String,
    val previewText: String,
    val text: String
)