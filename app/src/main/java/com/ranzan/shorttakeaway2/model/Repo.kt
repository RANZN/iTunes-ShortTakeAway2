package com.ranzan.shorttakeaway2.model

import com.ranzan.shorttakeaway2.model.api.Network
import com.ranzan.shorttakeaway2.model.api.ResponseModel

class Repo {
    suspend fun getDataFromApi(text: String): ResponseModel {
        return Network.apiService.getData(text)
    }
}