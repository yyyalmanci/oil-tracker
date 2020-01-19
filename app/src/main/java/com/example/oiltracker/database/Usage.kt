package com.example.oiltracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usage::class],version = 1,exportSchema = false)
abstract class UsageDatabase : RoomDatabase(){
    abstract val UsageDao: UsageDao
    companion object{

        @Volatile
        private var INSTANCE: UsageDatabase? = null

        fun getInstance(context: Context):UsageDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance== null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        UsageDatabase::class.java,
                        "oil_usage_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}