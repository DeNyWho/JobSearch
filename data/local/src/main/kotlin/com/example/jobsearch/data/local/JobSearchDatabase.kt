package com.example.jobsearch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jobsearch.data.local.converters.ListStringConverter
import com.example.jobsearch.data.local.converters.LocalDateConverter
import com.example.jobsearch.data.local.dao.vacancy.VacancyDao
import com.example.jobsearch.data.local.model.vacancy.AddressEntity
import com.example.jobsearch.data.local.model.vacancy.ExperienceEntity
import com.example.jobsearch.data.local.model.vacancy.SalaryEntity
import com.example.jobsearch.data.local.model.vacancy.VacancyEntity

@Database(
    entities = [
        VacancyEntity::class,
        AddressEntity::class,
        ExperienceEntity::class,
        SalaryEntity::class,
    ],
    version = 2,
    exportSchema = true,
)
@TypeConverters(LocalDateConverter::class, ListStringConverter::class)
internal abstract class JobSearchDatabase: RoomDatabase() {
    abstract fun vacancyDao(): VacancyDao
}