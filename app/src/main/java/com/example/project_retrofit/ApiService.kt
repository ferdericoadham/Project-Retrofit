package com.example.project_retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET ("character")

    fun getData(): Call<ResponseData>

}