package com.dmgdavid2109.remotejobsearcher.common.ui

import androidx.lifecycle.MutableLiveData

/**
 * MutableLiveData with helper functions to help update a ViewState
 */
class ViewStateLiveData<T>(initialState: T) : MutableLiveData<T>() {

    init {
        value = initialState
    }

    val currentState: T?
        get() = value

    fun updateCurrentState(newStateCreator: T.() -> T) {
        value = value?.newStateCreator()
    }
}
