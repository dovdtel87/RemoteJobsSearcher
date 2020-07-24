package com.dmgdavid2109.remotejobsearcher.jobs.data.mapper

import com.dmgdavid2109.remotejobsearcher.common.data.Mapper
import com.dmgdavid2109.remotejobsearcher.jobs.data.model.CompanyDTO
import com.dmgdavid2109.remotejobsearcher.jobs.domain.model.Company

class CompaniesMapper<T, U>() : Mapper<CompanyDTO, Company> {

    override fun map(input: CompanyDTO): Company {
        with(input) {
            return Company(
                "aName",
                "anUrl"   // TODO IMPLEMENT THE MAPPER
            )
        }
    }
}
