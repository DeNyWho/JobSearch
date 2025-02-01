package com.example.jobsearch.core.uikit.param

import com.example.jobsearch.domain.model.offers.Button
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.model.vacancies.Address
import com.example.jobsearch.domain.model.vacancies.Experience
import com.example.jobsearch.domain.model.vacancies.Salary
import com.example.jobsearch.domain.model.vacancies.Vacancy
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import java.time.LocalDate
import java.util.UUID
import kotlin.math.exp

object GlobalParams {
    val OfferSingle: Offer = Offer(
        id = "level_up_resume",
        title = "Поднять резюме в поиске",
        button = Button(
            text = "Поднять",
        ),
        link = "https://hh.ru/mentors?from\u003dfooter_new\u0026hhtmFromLabel\u003dfooter_new\u0026hhtmFrom\u003dmain\u0026purposeId\u003d1",
    )

    val Offers: ImmutableList<Offer> = listOf(OfferSingle, OfferSingle.copy(id = UUID.randomUUID().toString()), OfferSingle.copy(id = UUID.randomUUID().toString())).toImmutableList()

    val VacancySingle: Vacancy = Vacancy(
        id = UUID.randomUUID().toString(),
        lookingNumber = 2,
        title = "UI/UX дизайнер",
        address = Address(
            town = "Минск",
            street = "улица Бирюзова",
            house = "4/5",
        ),
        company = "Мобирикс",
        experience = Experience(
            previewText = "Опыт от 1 до 3 лет",
            text = "1–3 года",
        ),
        publishedDate = LocalDate.now(),
        isFavorite = false,
        salary = Salary(
            full = "Уровень дохода не указан",
        ),
        schedules = listOf("полная занятость", "полный день"),
        appliedNumber = 147,
        description = "Мы ищем специалиста на позицию UX/UI Designer, который вместе с коллегами будет заниматься проектированием пользовательских интерфейсов внутренних и внешних продуктов компании.",
        responsibilities = "- проектирование пользовательских сценариев и создание прототипов;\n- разработка интерфейсов для продуктов компании (Web+App);\n- работа над созданием и улучшением Дизайн-системы;\n- взаимодействие с командами frontend-разработки;\n- контроль качества внедрения дизайна;\n- ситуативно: создание презентаций и других материалов на основе фирменного стиля компании",
        questions = listOf("Где располагается место работы?", "Какой график работы?", "Вакансия открыта?")
    )

    val Vacancies: ImmutableList<Vacancy> = listOf(VacancySingle, VacancySingle.copy(id = UUID.randomUUID().toString()), VacancySingle.copy(id = UUID.randomUUID().toString())).toImmutableList()

}