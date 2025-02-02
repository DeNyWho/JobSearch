package com.example.jobsearch.data.local.model.vacancy

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "vacancy_address",
    foreignKeys = [
        ForeignKey(
            entity = VacancyEntity::class,
            parentColumns = ["id"],
            childColumns = ["vacancyId"],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class AddressEntity(
    @PrimaryKey val vacancyId: String,
    val town: String,
    val street: String,
    val house: String
)