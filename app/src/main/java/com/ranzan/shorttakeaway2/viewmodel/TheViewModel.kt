package com.ranzan.shorttakeaway2.viewmodel

import androidx.lifecycle.*
import com.ranzan.shorttakeaway2.model.Repo
import com.ranzan.shorttakeaway2.model.api.ResponseModel
import com.ranzan.shorttakeaway2.model.api.ResultsItem
import kotlinx.coroutines.launch


class ViewModelFactory(private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TheViewModel(repo) as T
    }

}

class TheViewModel(val repo: Repo) : ViewModel() {

    private lateinit var list: MutableLiveData<ResponseModel>

    fun getDataFromApi(text: String): LiveData<ResultsItem> {
        viewModelScope.launch {

            list.postValue(repo.getDataFromApi(text))
        }
        return list as LiveData<ResultsItem>
    }
}