package com.dmgdavid2109.remotejobsearcher.jobs.domain.repository

import com.dmgdavid2109.remotejobsearcher.jobs.domain.model.Company
import com.dmgdavid2109.remotejobsearcher.common.data.Result

interface CompaniesRepository {
    suspend fun getCompanies(): Result<List<Company>>
}
