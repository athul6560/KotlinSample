package com.azstudio.kotlinsample.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.azstudio.kotlinsample.entities.SampleData
import kotlinx.coroutines.flow.Flow

@Dao
interface SampleDao {
    @Insert
   suspend fun insert(sampleData: SampleData)

    @Update
    suspend fun update(sampleData: SampleData)

    @Query("DELETE FROM sample_table")
    suspend  fun clear()

    @Query("SELECT * FROM SAMPLE_TABLE")
    fun getAllSampleData(): Flow<List<SampleData>>
}