package com.dmgdavid2109.remotejobsearcher.jobs.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompanyDTO(
    val nombre: String,
    val url: String
)
