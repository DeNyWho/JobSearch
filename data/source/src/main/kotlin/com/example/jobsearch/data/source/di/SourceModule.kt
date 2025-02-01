package com.example.jobsearch.data.source.di

import com.example.jobsearch.data.network.service.JobService
import com.example.jobsearch.data.source.repository.offers.OffersRepositoryImpl
import com.example.jobsearch.data.source.repository.vacancies.VacanciesRepositoryImpl
import com.example.jobsearch.domain.repository.offers.OffersRepository
import com.example.jobsearch.domain.repository.vacancies.VacanciesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object SourceModule {

    @Provides
    @Singleton
    fun provideOffersRepository(
        jobService: JobService,
    ): OffersRepository {
        return OffersRepositoryImpl(
            jobService = jobService,
        )
    }

    @Provides
    @Singleton
    fun provideVacanciesRepository(
        jobService: JobService,
    ): VacanciesRepository {
        return VacanciesRepositoryImpl(
            jobService = jobService,
        )
    }
}