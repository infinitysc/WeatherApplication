package com.pallplication.FragA.Network


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpClientCreator {

    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
    private val clientCreator = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    fun getClient() : OkHttpClient {return clientCreator}

}