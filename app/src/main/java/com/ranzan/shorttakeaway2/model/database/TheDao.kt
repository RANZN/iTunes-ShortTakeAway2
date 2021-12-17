package com.ranzan.shorttakeaway2.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface TheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addData(data: TheEntity)

    @Query("select * from `offline data`")
    fun getData(): LiveData<TheEntity>

}