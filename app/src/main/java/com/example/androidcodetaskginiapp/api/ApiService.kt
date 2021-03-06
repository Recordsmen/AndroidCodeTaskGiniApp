package com.example.androidcodetaskginiapp.api

import com.example.androidcodetaskginiapp.Constants
import com.example.androidcodetaskginiapp.model.ImageModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


object ApiService {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(Constants.BASE_URL)
        .build()

    interface ImageApiService {
        @GET(Constants.KEY)
        suspend fun getImages(): ImageModel
    }

    val retrofitService: ImageApiService by lazy {
        retrofit.create(ImageApiService::class.java)
    }
}
