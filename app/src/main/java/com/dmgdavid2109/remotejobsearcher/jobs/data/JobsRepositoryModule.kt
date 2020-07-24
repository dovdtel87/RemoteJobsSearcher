package com.dmgdavid2109.remotejobsearcher.jobs.data

import com.dmgdavid2109.remotejobsearcher.common.data.Mapper
import com.dmgdavid2109.remotejobsearcher.jobs.data.api.CompaniesApi
import com.dmgdavid2109.remotejobsearcher.jobs.data.mapper.CompaniesMapper
import com.dmgdavid2109.remotejobsearcher.jobs.data.model.CompanyDTO
import com.dmgdavid2109.remotejobsearcher.jobs.data.repository.CompaniesRepositoryImpl
import com.dmgdavid2109.remotejobsearcher.jobs.domain.model.Company
import com.dmgdavid2109.remotejobsearcher.jobs.domain.repository.CompaniesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
abstract class JobsRepositoryModule {

    @Binds
    @ActivityScoped
    internal abstract fun companiesRepository(repository: CompaniesRepositoryImpl): CompaniesRepository

    @Binds
    internal abstract fun mapper(mapper: CompaniesMapper): Mapper<CompanyDTO, Company>

    companion object {
        @Provides
        @ActivityScoped
        internal fun provideApi(
            retrofit: Retrofit
        ): CompaniesApi {
            return retrofit.create(CompaniesApi::class.java)
        }
    }
}
