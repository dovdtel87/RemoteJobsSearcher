package com.dmgdavid2109.remotejobsearcher.common.ui

import com.dmgdavid2109.poqtest.common.ui.LceViewModelInputs
import com.dmgdavid2109.remotejobsearcher.common.ui.customviews.LoadingView

fun LoadingView.setViewState(viewState: LceViewState) {
    when {
        viewState.isLoading -> status(LoadingView.VisibilityState.LOADING)
        viewState.errorMessage != null -> status(LoadingView.VisibilityState.OFFLINE)
        else -> status(LoadingView.VisibilityState.GONE)
    }
}

fun LoadingView.setViewModelInputs(viewModelInputs: LceViewModelInputs) {
    setRetryListener(viewModelInputs::retry)
}
