package com.ranzan.shorttakeaway2.model.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun getData(@Query("term") text: String): ResponseModel
}