package com.ranzan.shorttakeaway2.viewmodel

import androidx.lifecycle.*
import com.ranzan.shorttakeaway2.model.Repo
import com.ranzan.shorttakeaway2.model.api.ResponseModel
import kotlinx.coroutines.launch


class ViewModelFactory(private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TheViewModel(repo) as T
    }

}

class TheViewModel(val repo: Repo) : ViewModel() {

    private var list = MutableLiveData<ResponseModel>()

    fun getDataFromApi(text: String): LiveData<ResponseModel> {
        viewModelScope.launch {

            list.postValue(repo.getDataFromApi(text))
        }
        return list
    }
}