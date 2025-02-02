package com.example.jobsearch.data.source.di

import com.example.jobsearch.domain.repository.offers.OffersRepository
import com.example.jobsearch.domain.repository.vacancies.VacanciesLocalRepository
import com.example.jobsearch.domain.repository.vacancies.VacanciesRepository
import com.example.jobsearch.domain.usecase.offers.GetOffersUseCase
import com.example.jobsearch.domain.usecase.vacancies.GetFavouriteVacanciesUseCase
import com.example.jobsearch.domain.usecase.vacancies.GetVacanciesUseCase
import com.example.jobsearch.domain.usecase.vacancies.InsertLocalVacanciesUseCase
import com.example.jobsearch.domain.usecase.vacancies.UpdateLocalFavouriteVacanciesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetVacanciesUseCase(vacanciesRepository: VacanciesRepository): GetVacanciesUseCase {
        return GetVacanciesUseCase(vacanciesRepository)
    }

    @Provides
    @Singleton
    fun provideGetFavouriteVacanciesUseCase(vacanciesLocalRepository: VacanciesLocalRepository): GetFavouriteVacanciesUseCase {
        return GetFavouriteVacanciesUseCase(vacanciesLocalRepository)
    }

    @Provides
    @Singleton
    fun provideInsertLocalVacanciesUseCase(vacanciesLocalRepository: VacanciesLocalRepository): InsertLocalVacanciesUseCase {
        return InsertLocalVacanciesUseCase(vacanciesLocalRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateLocalFavouriteVacanciesUseCase(vacanciesLocalRepository: VacanciesLocalRepository): UpdateLocalFavouriteVacanciesUseCase {
        return UpdateLocalFavouriteVacanciesUseCase(vacanciesLocalRepository)
    }

    @Provides
    @Singleton
    fun provideGetOffersUseCase(offersRepository: OffersRepository): GetOffersUseCase {
        return GetOffersUseCase(offersRepository)
    }
}
