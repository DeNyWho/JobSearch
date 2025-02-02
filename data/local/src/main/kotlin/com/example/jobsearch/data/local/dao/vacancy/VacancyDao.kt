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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancy(vacancy: VacancyEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAddress(address: AddressEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExperience(experience: ExperienceEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSalary(salary: SalaryEntity)

    @Transaction
    suspend fun insertVacancy(
        vacancy: VacancyEntity,
        address: AddressEntity,
        experience: ExperienceEntity,
        salary: SalaryEntity
    ): Long {
        val vacancyId = insertVacancy(vacancy)
        insertAddress(address)
        insertExperience(experience)
        insertSalary(salary)
        return vacancyId
    }

    @Transaction
    @Query("SELECT * FROM vacancy WHERE id = :vacancyId")
    suspend fun getVacancyById(vacancyId: String): VacancyWithDetails?

    @Query("SELECT * FROM vacancy")
    fun getVacancies(): List<VacancyWithDetails>

    @Transaction
    @Query("SELECT * FROM vacancy WHERE isFavorite = 1")
    fun getFavoriteVacancies(): Flow<List<VacancyWithDetails>>

    @Query("UPDATE vacancy SET isFavorite = NOT isFavorite WHERE id = :vacancyId")
    suspend fun updateFavoriteStatus(vacancyId: String)

    @Query("DELETE FROM vacancy WHERE id = :vacancyId")
    suspend fun deleteVacancy(vacancyId: String)
}