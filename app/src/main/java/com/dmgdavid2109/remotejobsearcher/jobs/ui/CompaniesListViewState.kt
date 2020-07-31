package com.dmgdavid2109.remotejobsearcher.jobs.ui

import com.dmgdavid2109.remotejobsearcher.common.ui.LceViewState
import com.dmgdavid2109.remotejobsearcher.jobs.domain.model.Company

data class CompaniesListViewState(
    override val isLoading: Boolean = true,
    override val errorMessage: Int? = null,
    val companiesList: List<Company> = emptyList()
) : LceViewState
