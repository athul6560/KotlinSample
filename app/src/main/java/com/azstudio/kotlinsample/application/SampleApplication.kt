package com.azstudio.kotlinsample.application

import android.app.Application
import com.azstudio.kotlinsample.repo.SampleRepo
import com.azstudio.kotlinsample.roomdb.database.SampleDatabase

class SampleApplication:Application() {
    private val database by lazy {
        SampleDatabase.getInstance(this@SampleApplication)
    }

    val repository by lazy {
        SampleRepo(database.sampleDao)
    }
}