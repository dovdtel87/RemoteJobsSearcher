package com.dmgdavid2109.remotejobsearcher.jobs.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.dmgdavid2109.poqtest.common.ui.viewBinding
import com.dmgdavid2109.remotejobsearcher.R
import com.dmgdavid2109.remotejobsearcher.common.ui.setViewModelInputs
import com.dmgdavid2109.remotejobsearcher.common.ui.setViewState
import com.dmgdavid2109.remotejobsearcher.databinding.JobsListFragmentBinding
import com.dmgdavid2109.remotejobsearcher.di.ViewModelFactory
import javax.inject.Inject

class JobsListFragment @Inject constructor(
    private val viewModelFactory: ViewModelFactory<JobsListViewModel>
) : Fragment((R.layout.jobs_list_fragment)) {

    private val binding by viewBinding(JobsListFragmentBinding::bind)

    private val jobsListViewModel: JobsListViewModel by viewModels {
        viewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindView()
        jobsListViewModel.loadList()
    }

    private fun bindView() {
        val listAdapter = RepositoriesListAdapter()

        binding.list.adapter = listAdapter
        binding.loadingView.setViewModelInputs(jobsListViewModel)

        jobsListViewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            listAdapter.submitList(viewState.companiesList)
            binding.loadingView.setViewState(viewState)
        })
    }
}
