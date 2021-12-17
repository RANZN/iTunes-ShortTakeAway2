package com.ranzan.shorttakeaway2.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ranzan.shorttakeaway2.model.api.ResultsItem


@Entity(tableName = "Offline Data")
data class TheEntity(
    @PrimaryKey
    @ColumnInfo(name = "Key")
    val key: String,
    @ColumnInfo(name = "Data")
    val data: ResultsItem
)