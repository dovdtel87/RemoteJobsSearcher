package com.dmgdavid2109.remotejobsearcher.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class ApiConfigsModule {

    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/dovdtel87/495b5021d83bc3e4b635c50b0a286663/raw/66a5859d7814c821a31dcb90d305ac6014210de5/" // TODO UPDATE URL
    }

    @Provides
    @ApiConfig
    fun providesApiUrl(): String {
        return BASE_URL
    }
}
