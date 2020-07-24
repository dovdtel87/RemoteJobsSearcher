package com.dmgdavid2109.remotejobsearcher.jobs.data.repository

import com.dmgdavid2109.remotejobsearcher.common.data.ListMapper
import com.dmgdavid2109.remotejobsearcher.jobs.data.api.CompaniesApi
import com.dmgdavid2109.remotejobsearcher.jobs.data.model.CompanyDTO
import com.dmgdavid2109.remotejobsearcher.jobs.domain.model.Company
import com.dmgdavid2109.remotejobsearcher.jobs.domain.repository.CompaniesRepository

import com.dmgdavid2109.remotejobsearcher.common.data.Result
import com.dmgdavid2109.remotejobsearcher.common.data.toResult

class CompaniesRepositoryImpl(
    private val companiesApi: CompaniesApi,
    private val companiesMapper: ListMapper<CompanyDTO, Company>
) : CompaniesRepository {

    override suspend fun getCompanies(): Result<List<Company>> {
        return try {
            companiesApi.retrieveCompanies().toResult { response ->
                companiesMapper.map(response.items)
            }
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}
