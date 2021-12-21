package com.azstudio.kotlinsample.roomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.azstudio.kotlinsample.entities.SampleData
import com.azstudio.kotlinsample.roomdb.dao.SampleDao

@Database(entities = [SampleData::class], version = 1, exportSchema = false)
abstract  class SampleDatabase  : RoomDatabase(){
    abstract val sampleDao: SampleDao

    companion object {

        @Volatile
        private var INSTANCE: SampleDatabase? = null

        fun getInstance(context: Context): SampleDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SampleDatabase::class.java,
                        "sample_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
