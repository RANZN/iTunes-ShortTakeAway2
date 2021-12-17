package com.ranzan.shorttakeaway2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ranzan.shorttakeaway2.model.Repo
import com.ranzan.shorttakeaway2.model.database.TheEntity

class ViewModelFactory(private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TheViewModel(repo) as T
    }

}

class TheViewModel(private val repo: Repo) : ViewModel() {


    fun getDataFromApi(text: String): LiveData<List<TheEntity>> {
        return repo.getDataFromApi(text)
    }

    /*
    fun getDataFromApi(text: String): LiveData<ResponseModel> {

        val dataList = liveData<ResponseModel> {
            val data = repo.getDataFromApi(text)
            repo.addToDataBase(data.results)
            emit(data)
        }
        return dataList
    }



    //    Another way to get Data pass data
    private var liveDataList = MutableLiveData<ResponseModel>()

    fun getDataFromApi(text: String): LiveData<ResponseModel> {
        viewModelScope.launch {
            liveDataList.postValue(repo.getDataFromApi(text))
        }
        return liveDataList
    }
*/


}