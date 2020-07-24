package com.dmgdavid2109.remotejobsearcher.jobs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dmgdavid2109.remotejobsearcher.R
import com.dmgdavid2109.remotejobsearcher.di.FragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: FragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.fragmentFactory = fragmentFactory
        setContentView(R.layout.activity_main)
    }
}
