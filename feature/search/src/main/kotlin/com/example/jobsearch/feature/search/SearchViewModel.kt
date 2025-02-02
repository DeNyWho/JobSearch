package com.example.jobsearch.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobsearch.domain.model.offers.Offer
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.domain.usecase.offers.GetOffersUseCase
import com.example.jobsearch.domain.usecase.vacancies.GetVacanciesUseCase
import com.example.jobsearch.domain.usecase.vacancies.UpdateLocalFavouriteVacanciesUseCase
import com.example.jobsearch.feature.search.model.state.SearchUiState
import com.example.jobsearch.feature.search.model.ui.SearchUiScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SearchViewModel @Inject constructor(
    private val getOffersUseCase: GetOffersUseCase,
    private val getVacanciesUseCase: GetVacanciesUseCase,
    private val updateLocalFavouriteVacanciesUseCase: UpdateLocalFavouriteVacanciesUseCase,
): ViewModel() {
    private val _uiState: MutableStateFlow<SearchUiState> =
        MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    private val _offers: MutableStateFlow<StateListWrapper<Offer>> =
        MutableStateFlow(StateListWrapper.loading())
    val offers: StateFlow<StateListWrapper<Offer>> = _offers.asStateFlow()

    private val _vacancies: MutableStateFlow<StateListWrapper<Vacancy>> =
        MutableStateFlow(StateListWrapper.loading())
    val vacancies: StateFlow<StateListWrapper<Vacancy>> = _vacancies.asStateFlow()

    private val _vacanciesForYou: MutableStateFlow<StateListWrapper<Vacancy>> =
        MutableStateFlow(StateListWrapper.loading())
    val vacanciesForYou: StateFlow<StateListWrapper<Vacancy>> = _vacanciesForYou.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            launch { getOffers() }
            launch { getVacancies() }
            launch { getVacanciesForYou() }
        }
    }

    private fun getOffers() {
        getOffersUseCase.invoke().onEach {
            _offers.value = it
        }.launchIn(viewModelScope)
    }

    private fun getVacancies() {
        viewModelScope.launch {
            getVacanciesUseCase.invoke().onEach {
                _vacancies.value = it
            }.launchIn(viewModelScope)
        }
    }

    private fun getVacanciesForYou() {
        viewModelScope.launch {
            getVacanciesUseCase.invoke(isForYou = true).onEach {
                _vacanciesForYou.value = it
            }.launchIn(viewModelScope)
        }
    }

    fun changeFavourite(vacancy: Vacancy) {
        viewModelScope.launch {
            updateLocalFavouriteVacanciesUseCase.invoke(vacancy)
        }
    }

    fun changeUiState() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                uiScreen = if (_uiState.value.uiScreen == SearchUiScreen.ForYou) {
                    SearchUiScreen.All
                } else {
                    SearchUiScreen.ForYou
                }
            )
        }
    }
}