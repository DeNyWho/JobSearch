package com.example.jobsearch.data.local.di

import com.example.jobsearch.data.local.JobSearchDatabase
import com.example.jobsearch.data.local.dao.vacancy.VacancyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {
    @Provides
    fun provideVacancyDao(
        database: JobSearchDatabase,
    ): VacancyDao = database.vacancyDao()
}