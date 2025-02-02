package com.example.jobsearch.data.local.mappers.vacancy

import com.example.jobsearch.data.local.model.vacancy.AddressEntity
import com.example.jobsearch.data.local.model.vacancy.ExperienceEntity
import com.example.jobsearch.data.local.model.vacancy.SalaryEntity
import com.example.jobsearch.data.local.model.vacancy.VacancyEntity
import com.example.jobsearch.data.local.model.vacancy.VacancyWithDetails
import com.example.jobsearch.domain.model.vacancies.Address
import com.example.jobsearch.domain.model.vacancies.Experience
import com.example.jobsearch.domain.model.vacancies.Salary
import com.example.jobsearch.domain.model.vacancies.Vacancy

fun Vacancy.toVacancyEntity(): VacancyEntity = VacancyEntity(
    id = id,
    lookingNumber = lookingNumber,
    title = title,
    company = company,
    publishedDate = publishedDate,
    isFavorite = isFavorite,
    schedules = schedules,
    appliedNumber = appliedNumber,
    description = description,
    responsibilities = responsibilities,
    questions = questions,
)

fun Vacancy.toAddressEntity(): AddressEntity = AddressEntity(
    vacancyId = id,
    town = address.town,
    street = address.street,
    house = address.house,
)

fun Vacancy.toExperienceEntity(): ExperienceEntity = ExperienceEntity(
    vacancyId = id,
    previewText = experience.previewText,
    text = experience.text,
)

fun Vacancy.toSalaryEntity(): SalaryEntity = SalaryEntity(
    vacancyId = id,
    full = salary.full,
    short = salary.short,
)

fun VacancyWithDetails.toVacancy(): Vacancy = Vacancy(
    id = vacancy.id,
    lookingNumber = vacancy.lookingNumber,
    title = vacancy.title,
    address = Address(
        town = address.town,
        street = address.street,
        house = address.house,
    ),
    company = vacancy.company,
    experience = Experience(
        previewText = experience.previewText,
        text = experience.text,
    ),
    publishedDate = vacancy.publishedDate,
    isFavorite = vacancy.isFavorite,
    salary = Salary(
        full = salary.full,
        short = salary.short,
    ),
    schedules = vacancy.schedules,
    appliedNumber = vacancy.appliedNumber,
    description = vacancy.description,
    responsibilities = vacancy.responsibilities,
    questions = vacancy.questions,
)