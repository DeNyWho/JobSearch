package com.example.jobsearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobsearch.domain.model.vacancies.Vacancy
import com.example.jobsearch.domain.state.StateListWrapper
import com.example.jobsearch.domain.usecase.vacancies.GetFavouriteVacanciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getFavouriteVacanciesUseCase: GetFavouriteVacanciesUseCase,
) : ViewModel() {
    private val _vacancies: MutableStateFlow<StateListWrapper<Vacancy>> =
        MutableStateFlow(StateListWrapper.loading())
    val vacancies: StateFlow<StateListWrapper<Vacancy>> = _vacancies.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            getFavouriteVacanciesUseCase.invoke().onEach {
                _vacancies.value = it
            }.launchIn(viewModelScope)
        }
    }
}