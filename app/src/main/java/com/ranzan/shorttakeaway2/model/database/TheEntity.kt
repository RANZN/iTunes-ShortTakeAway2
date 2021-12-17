package com.ranzan.shorttakeaway2.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Offline Data")
data class TheEntity(

    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "Track Name")
    val trackName: String,
    @ColumnInfo(name = "Artist Name")
    val artistName: String,
    @ColumnInfo(name = "Track Image")
    val trackImage: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}
