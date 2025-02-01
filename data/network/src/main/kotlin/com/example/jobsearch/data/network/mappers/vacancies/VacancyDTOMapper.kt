package com.example.jobsearch.data.network.mappers.vacancies

import com.example.jobsearch.data.network.models.dto.vacancies.AddressDTO
import com.example.jobsearch.data.network.models.dto.vacancies.ExperienceDTO
import com.example.jobsearch.data.network.models.dto.vacancies.SalaryDTO
import com.example.jobsearch.data.network.models.dto.vacancies.VacancyDTO
import com.example.jobsearch.domain.model.vacancies.Address
import com.example.jobsearch.domain.model.vacancies.Experience
import com.example.jobsearch.domain.model.vacancies.Salary
import com.example.jobsearch.domain.model.vacancies.Vacancy

fun VacancyDTO.toVacancy(): Vacancy = Vacancy(
    id = id,
    lookingNumber = lookingNumber,
    title = title,
    address = address.toAddress(),
    company = company,
    experience = experience.toExperience(),
    publishedDate = publishedDate,
    isFavorite = isFavorite,
    salary = salary.toSalary(),
    schedules = schedules,
    appliedNumber = appliedNumber,
    description = description,
    responsibilities = responsibilities,
    questions = questions,
)

fun AddressDTO.toAddress(): Address = Address(
    town = town,
    street = street,
    house = house,
)

fun ExperienceDTO.toExperience(): Experience = Experience(
    previewText = previewText,
    text = text,
)

fun SalaryDTO.toSalary(): Salary = Salary(
    full = full,
    short = short,
)