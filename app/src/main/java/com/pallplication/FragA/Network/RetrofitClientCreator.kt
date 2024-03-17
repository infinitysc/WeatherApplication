package com.pallplication.FragA.Network

import android.util.Log
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import com.pallplication.FragA.Network.DataExtClass as DataExtClass

class RetrofitClientCreator {
    private val okhttpClient = OkHttpClientCreator()

    private val retrofitCreator = Retrofit.Builder()
        .client(okhttpClient.getClient())
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val adapterApi = retrofitCreator.create(ApInterface::class.java)

    suspend fun fgdg(): DataExtClass {
        val callEx = adapterApi.getContact()

        val callClassEx = adapterApi.getClassContact()
        try {
        }
        catch (e : IOException){
            Log.e("TAG", "$e")
        }
        return callClassEx
    }

}