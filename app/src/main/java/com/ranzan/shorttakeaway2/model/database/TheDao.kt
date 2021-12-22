package com.ranzan.shorttakeaway2.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ranzan.shorttakeaway2.model.api.ResultsItem


@Dao
interface TheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addData(theEntity: TheEntity)

    @Query("select * from `offline data` where text=:text")
    fun getData(text: String): LiveData<List<ResultsItem>>

}
