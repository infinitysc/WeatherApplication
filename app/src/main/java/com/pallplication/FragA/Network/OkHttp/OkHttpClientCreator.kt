package com.pallplication.FragA.Network.OkHttp


import android.util.Log
import com.google.gson.Gson
import com.pallplication.FragA.Network.FinalAirQuiality
import com.pallplication.FragA.Network.UrlCreator
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException
/**
 * Класс создающий HTTPclient
 **/
class OkHttpClientCreator {

    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
    private val myInterceptor = HttpLoggingInterceptor()


    private val clientCreator = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    fun getClient() : OkHttpClient {
        return clientCreator
    }

}