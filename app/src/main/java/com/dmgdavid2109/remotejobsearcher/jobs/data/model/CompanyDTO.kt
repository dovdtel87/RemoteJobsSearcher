package com.dmgdavid2109.remotejobsearcher.jobs.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompanyDTO(
    @Json(name = "nombre") val nombre: String,
    @Json(name = "url") val url: String
)
