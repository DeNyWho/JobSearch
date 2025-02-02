package com.example.jobsearch.data.local.dao.vacancy

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.jobsearch.data.local.model.vacancy.AddressEntity
import com.example.jobsearch.data.local.model.vacancy.ExperienceEntity
import com.example.jobsearch.data.local.model.vacancy.SalaryEntity
import com.example.jobsearch.data.local.model.vacancy.VacancyEntity
import com.example.jobsearch.data.local.model.vacancy.VacancyWithDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface VacancyDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancy(
        vacancy: VacancyEntity,
        address: AddressEntity,
        experience: ExperienceEntity,
        salary: SalaryEntity
    )

    @Transaction
    @Query("SELECT * FROM vacancy WHERE id = :vacancyId")
    suspend fun getVacancyById(vacancyId: String): VacancyWithDetails?

    @Transaction
    @Query("SELECT * FROM vacancy WHERE isFavorite = 1")
    fun getFavoriteVacancies(): Flow<List<VacancyWithDetails>>

    @Query("UPDATE vacancy SET isFavorite = :isFavorite WHERE id = :vacancyId")
    suspend fun updateFavoriteStatus(vacancyId: String, isFavorite: Boolean)

    @Query("DELETE FROM vacancy WHERE id = :vacancyId")
    suspend fun deleteVacancy(vacancyId: String)
}