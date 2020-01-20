package com.falanapp.oiltracker.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsageDao{

    @Insert
    fun insert(usage: Usage)

    @Update
    fun update(usage: Usage)

    @Query("SELECT * from usage_for_oil where  usageId= :id")
    fun get(id:Int) : Usage?

    @Query("DELETE FROM USAGE_FOR_OIL")
    fun clear()

    @Query("select * from usage_for_oil order by  usageId desc")
    fun getAllUsages() : LiveData<List<Usage>>


}