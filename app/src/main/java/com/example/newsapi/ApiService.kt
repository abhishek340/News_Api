package com.example.newsapi

import com.example.newsapi.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {

    @GET("top-headlines?country=in")
    suspend fun getNews(@Header("Authorization") Authorization:String) : Response<NewsResponse>

   // apiKey=2bb3cc6d93344f4e80353af1c59bc9b0

}