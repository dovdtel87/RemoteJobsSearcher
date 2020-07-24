package com.dmgdavid2109.remotejobsearcher.jobs.data.api

import com.dmgdavid2109.remotejobsearcher.jobs.data.model.CompaniesResponse
import retrofit2.Response
import retrofit2.http.GET

interface CompaniesApi {
    @GET("/companies")
    suspend fun retrieveCompanies(): Response<CompaniesResponse>
}
