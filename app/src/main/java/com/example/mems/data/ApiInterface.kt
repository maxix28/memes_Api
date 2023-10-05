package com.example.mems.data

import com.example.mems.models.Mems
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("get_memes")
    suspend fun  getMemes():Response<Mems>
}