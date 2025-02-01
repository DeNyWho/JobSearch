package com.example.jobsearch.feature.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.domain.usecase.offers.GetOffersUseCase
import com.example.jobsearch.domain.usecase.vacancies.GetVacanciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SearchViewModel @Inject constructor(
    private val getOffersUseCase: GetOffersUseCase,
    private val getVacanciesUseCase: GetVacanciesUseCase,
): ViewModel() {

    private val _offers: MutableState<StateListWrapper<Offer>> =
        mutableStateOf(StateListWrapper.loading())
    val offers: MutableState<StateListWrapper<Offer>> = _offers

    private val _vacancies: MutableState<StateListWrapper<Vacancy>> =
        mutableStateOf(StateListWrapper.loading())
    val vacancies: MutableState<StateListWrapper<Vacancy>> = _vacancies

    private val _vacanciesForYou: MutableState<StateListWrapper<Vacancy>> =
        mutableStateOf(StateListWrapper.loading())
    val vacanciesForYou: MutableState<StateListWrapper<Vacancy>> = _vacanciesForYou

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            coroutineScope {
                launch {
                    getOffers()
                }
                launch {
                    getVacancies()
                }
                launch {
                    getVacanciesForYou()
                }
            }
        }
    }

    private fun getOffers() {
        getOffersUseCase.invoke().onEach {
            _offers.value = it
        }.launchIn(viewModelScope)
    }

    private fun getVacancies() {
        getVacanciesUseCase.invoke().onEach {
            _vacancies.value = it
        }.launchIn(viewModelScope)
    }

    private fun getVacanciesForYou() {
        getVacanciesUseCase.invoke().take(2).onEach {
            _vacanciesForYou.value = it
        }.launchIn(viewModelScope)
    }
}