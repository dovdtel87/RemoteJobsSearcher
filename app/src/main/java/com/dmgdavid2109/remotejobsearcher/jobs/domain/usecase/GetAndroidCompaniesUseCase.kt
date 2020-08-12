package com.dmgdavid2109.remotejobsearcher.jobs.domain.usecase

import android.util.Log
import com.dmgdavid2109.remotejobsearcher.common.data.Result
import com.dmgdavid2109.remotejobsearcher.jobs.domain.model.Company
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import javax.inject.Inject

class GetAndroidCompaniesUseCase @Inject constructor(
    private val getCompaniesUseCase: GetCompaniesUseCase
) {
    companion object {
        val KEY_WORD = "Android"
    }

    suspend operator fun invoke(): Result<List<Company>> {
        val result = getCompaniesUseCase()

        return if (result is Result.Success) {
            Result.Success(scanCompanies(result.data))
        } else {
            Result.Error(Exception())
        }
    }

    private suspend fun scanCompanies(items: List<Company>) : List<Company>{
        val listCompanies = arrayListOf<Company>()
        withContext(Dispatchers.IO) {
            var counter = 0
            for (company in items) {
                counter++
                scanLink(company, counter, items.size)?.let {
                    listCompanies.add(it)
                }
            }
        }
        return listCompanies
    }

    private fun scanLink(company: Company, counter: Int, size: Int) : Company? {
        Log.d("Test", "Scanning: "+ company.name+" "+ counter+"/"+size)
        var webText = ""
        try {
            webText = URL(company.url).readText()
        } catch (exception : Exception) {
            Log.d("Test", ""+ company.name+" EXCEPTION!!")
        }
        
        return if (webText.contains(KEY_WORD)) {
            Log.d("Test", ""+ company.name+" has "+ KEY_WORD+" job!!")
            company
        } else {
            null
        }
    }
}
