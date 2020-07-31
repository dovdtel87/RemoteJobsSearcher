package com.dmgdavid2109.remotejobsearcher.jobs.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompaniesResponse(
    @Json(name = "items") val items: List<CompanyDTO>
)
