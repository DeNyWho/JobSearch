package com.example.jobsearch.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.jobsearch.data.local.JobSearchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesJobSearchDatabase(
        @ApplicationContext context: Context,
    ): JobSearchDatabase = Room.databaseBuilder(
        context,
        JobSearchDatabase::class.java,
        "job-search-database",
    )
        .fallbackToDestructiveMigration() // Use only until the application is released in the release version
        .build()
}
