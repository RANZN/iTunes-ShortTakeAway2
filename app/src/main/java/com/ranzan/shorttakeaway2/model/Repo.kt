package com.ranzan.shorttakeaway2.model

import androidx.lifecycle.LiveData
import com.ranzan.shorttakeaway2.model.api.Network
import com.ranzan.shorttakeaway2.model.database.TheDao
import com.ranzan.shorttakeaway2.model.database.TheEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repo(private val theDao: TheDao) {

    fun getDataFromApi(text: String): LiveData<List<TheEntity>> {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val list = Network.apiService.getData(text).results
                list!!.forEach {
                    it!!.apply {
                        theDao.addData(
                            TheEntity(
                                text,
                                trackName.toString(),
                                artistName.toString(),
                                artworkUrl100.toString()
                            )
                        )
                    }
                }
            } catch (e: Exception) {

            }
        }
        return theDao.getData(text)
    }
}