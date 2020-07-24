package com.dmgdavid2109.remotejobsearcher.jobs.ui

import androidx.fragment.app.Fragment
import com.dmgdavid2109.remotejobsearcher.di.FragmentKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityComponent::class)
abstract class JobsFragmentBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(JobsListFragment::class)
    abstract fun bindListFragment(mainFragment: JobsListFragment): Fragment

}
