package com.example.newsapi

import com.example.newsapi.Constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient private constructor() {

    companion object{
        private val api : Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


        val apiService : ApiService by lazy {
            api.create(ApiService::class.java)
        }
    }

}