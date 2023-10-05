package com.example.mems.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetofitInstance {
        val api :ApiInterface by lazy{
            Retrofit.Builder()
                .baseUrl(util.Base)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
}