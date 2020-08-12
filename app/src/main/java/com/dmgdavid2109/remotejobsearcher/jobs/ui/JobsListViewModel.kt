package com.dmgdavid2109.remotejobsearcher.jobs.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmgdavid2109.remotejobsearcher.R
import com.dmgdavid2109.remotejobsearcher.common.ui.ViewStateLiveData
import com.dmgdavid2109.remotejobsearcher.jobs.domain.model.Company
import com.dmgdavid2109.remotejobsearcher.jobs.domain.usecase.GetAndroidCompaniesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class JobsListViewModel @Inject constructor(
    private val getAndroidCompaniesUseCase: GetAndroidCompaniesUseCase
) : ViewModel(), JobsListViewModelInputs {

    private val _viewState = ViewStateLiveData(CompaniesListViewState())
    val viewState: LiveData<CompaniesListViewState>
        get() = _viewState

    fun loadList() {
        viewModelScope.launch {
            showStartLoading()
            val result = getAndroidCompaniesUseCase()
            result.fold(::showError, ::showCompaniesList)
        }
    }

    private fun showCompaniesList(items: List<Company>) {
        _viewState.updateCurrentState {
            copy(
                isLoading = false,
                errorMessage = null,
                companiesList = items
            )
        }
    }

    private fun showError(exception: Exception) {
        _viewState.updateCurrentState {
            copy(
                isLoading = false,
                errorMessage = R.string.generic_error
            )
        }
    }

    private fun showStartLoading() {
        _viewState.updateCurrentState {
            copy(isLoading = true)
        }
    }

    override fun retry() {
        loadList()
    }
}
