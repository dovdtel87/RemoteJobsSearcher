package com.dmgdavid2109.remotejobsearcher.jobs.domain.usecase

import com.dmgdavid2109.remotejobsearcher.common.data.Result
import com.dmgdavid2109.remotejobsearcher.jobs.domain.model.Company
import com.dmgdavid2109.remotejobsearcher.jobs.domain.repository.CompaniesRepository
import javax.inject.Inject

class GetCompaniesUseCase @Inject constructor(
    private val companiesRepository: CompaniesRepository
) {
    suspend operator fun invoke(): Result<List<Company>> {
        return companiesRepository.getCompanies()
    }
}
