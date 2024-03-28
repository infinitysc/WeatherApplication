package com.pallplication.FragA.Network.Retrofit

import android.util.Log
import com.pallplication.FragA.Network.FinalAirQuiality
import com.pallplication.FragA.Network.OkHttp.OkHttpClientCreator
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RetrofitClientCreator {
    private val okhttpClient = OkHttpClientCreator()

    private val retrofitCreator = Retrofit.Builder()
        .client(okhttpClient.getClient())
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val adapterApi = retrofitCreator.create(ApInterface::class.java)


}