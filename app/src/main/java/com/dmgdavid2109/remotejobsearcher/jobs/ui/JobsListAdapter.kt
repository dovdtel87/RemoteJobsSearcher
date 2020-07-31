package com.dmgdavid2109.remotejobsearcher.jobs.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dmgdavid2109.remotejobsearcher.databinding.JobListItemBinding
import com.dmgdavid2109.remotejobsearcher.jobs.domain.model.Company

class RepositoriesListAdapter() : ListAdapter<Company, RepositoryItemViewHolder>(object :
    DiffUtil.ItemCallback<Company>() {
    override fun areItemsTheSame(oldItem: Company, newItem: Company) = oldItem.name == newItem.name
    override fun areContentsTheSame(oldItem: Company, newItem: Company) = oldItem.name == newItem.name
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = JobListItemBinding.inflate(inflater, parent, false)
        return RepositoryItemViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: RepositoryItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class RepositoryItemViewHolder(
    private val context: Context,
    private val binding: JobListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Company) {
        binding.companyName.text = item.name
        binding.companyUrl.text = item.url
    }
}
