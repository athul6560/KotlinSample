package com.azstudio.kotlinsample.repo

import androidx.annotation.WorkerThread
import com.azstudio.kotlinsample.entities.SampleData
import com.azstudio.kotlinsample.roomdb.dao.SampleDao
import kotlinx.coroutines.flow.Flow

class SampleRepo(private val sampleDao: SampleDao) {
    @WorkerThread
    suspend fun insertSampleData(sampleData: SampleData){
        sampleDao.insert(sampleData)
    }

    val allSampleData: Flow<List<SampleData>> = sampleDao.getAllSampleData()
}