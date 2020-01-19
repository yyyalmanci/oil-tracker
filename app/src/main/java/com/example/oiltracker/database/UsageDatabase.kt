package com.example.oiltracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usage_for_oil")
data class Usage(
    @PrimaryKey(autoGenerate = true)
    var usageId:Int = 0,
    @ColumnInfo(name  = "deneme")
    var deneme: String?,
    @ColumnInfo(name = "deneme_2")
    var deneme2: String?
)