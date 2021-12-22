package com.ranzan.shorttakeaway2.model

import androidx.lifecycle.LiveData
import com.ranzan.shorttakeaway2.model.api.Network
import com.ranzan.shorttakeaway2.model.api.ResultsItem
import com.ranzan.shorttakeaway2.model.database.TheDao
import com.ranzan.shorttakeaway2.model.database.TheEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repo(private val theDao: TheDao) {

    fun getDataFromApi(text: String): LiveData<List<ResultsItem>> {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val list = Network.apiService.getData(text).results
                list!!.forEach {
                    theDao.addData(TheEntity(text, it!!))
                }
            } catch (e: Exception) {

            }
        }
        return theDao.getData(text)
    }
}