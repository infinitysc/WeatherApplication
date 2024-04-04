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
    private val clientCreator = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()


    private val urls = UrlCreator("https://api.met.no/weatherapi/airqualityforecast/0.1/",listOf(null,"60","10","grunnkrets",null,null,null)).getUrlString()

    private val requestCreate = Request.Builder()
        .url(urls)
        .build()

    fun getDataClass() : FinalAirQuiality? {
        try{
            clientCreator.newCall(requestCreate).execute().use {
                if(!it.isSuccessful){
                    throw IOException("not executed")
                }
                return Gson().fromJson(it.body!!.string(),FinalAirQuiality::class.java)
            }
        }
        catch(e_ : IOException){
            Log.e("OkHttpClientError","$e_")
            return null
        }
    }

    fun getClient() : OkHttpClient {return clientCreator}

}