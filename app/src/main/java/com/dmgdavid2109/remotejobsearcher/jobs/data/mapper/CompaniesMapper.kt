package com.dmgdavid2109.remotejobsearcher.jobs.data.mapper

import com.dmgdavid2109.remotejobsearcher.common.data.Mapper
import com.dmgdavid2109.remotejobsearcher.jobs.data.model.CompanyDTO
import com.dmgdavid2109.remotejobsearcher.jobs.domain.model.Company
import javax.inject.Inject

class CompaniesMapper @Inject constructor() : Mapper<CompanyDTO, Company> {

    override fun map(input: CompanyDTO): Company {
        with(input) {
            return Company(
                input.nombre,
                input.url
            )
        }
    }
}
