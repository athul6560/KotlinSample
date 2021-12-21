package com.azstudio.kotlinsample.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample_table")
data class SampleData(
    val sampleText: String,
    @PrimaryKey(autoGenerate = true)
    val primaryId: Int,
    @ColumnInfo(name = "start_time_milli")
    val updateTime: Long = System.currentTimeMillis()
)
