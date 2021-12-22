package com.ranzan.shorttakeaway2.model.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ranzan.shorttakeaway2.model.api.ResultsItem


@Entity(tableName = "offline data")
data class TheEntity(

    @ColumnInfo(name = "text")
    val text: String,

    @Embedded
    var resultsItem: ResultsItem
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}
