package com.azstudio.kotlinsample.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample_table")
data class SampleData(
    var sampleText: String,


){
    @PrimaryKey(autoGenerate = true)
    var primaryId: Int=0
    @ColumnInfo(name = "start_time_milli")
    var updateTime: Long = System.currentTimeMillis()
}
