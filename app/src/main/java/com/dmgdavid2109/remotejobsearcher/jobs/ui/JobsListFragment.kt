package com.dmgdavid2109.remotejobsearcher.jobs.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.dmgdavid2109.remotejobsearcher.R
import com.dmgdavid2109.remotejobsearcher.di.ViewModelFactory
import javax.inject.Inject

class JobsListFragment @Inject constructor(
    private val viewModelFactory: ViewModelFactory<JobsListViewModel>
) : Fragment((R.layout.jobs_list_fragment)) {

    private val jobsListViewModel: JobsListViewModel by viewModels {
        viewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindView()
        jobsListViewModel.loadList()
    }

    private fun bindView() {

        jobsListViewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            if (viewState.companiesList.isEmpty().not()) {
                Log.d("Test", viewState.companiesList[0].name)
            }
        })
    }
}
