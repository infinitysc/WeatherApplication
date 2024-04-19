package com.pallplication.FragA.Network.Retrofit

import android.util.Log
import com.pallplication.FragA.Network.FinalAirQuiality
import com.pallplication.FragA.Network.OkHttp.OkHttpClientCreator
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RetrofitClientCreator {
    private val okhttpClient = OkHttpClientCreator().getClient()

    private val retrofitCreator = Retrofit.Builder()
        .client(okhttpClient)
        .baseUrl("https://api.met.no/weatherapi/airqualityforecast/0.1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val adapterApi = retrofitCreator.create(ApInterface::class.java)

    fun getApi() = runBlocking { withContext(Dispatchers.IO){adapterApi.getDataClass()} }
    fun getAir(maps : Map<String,String>) = runBlocking { withContext(Dispatchers.IO){adapterApi.getAirClass(maps)} }



}