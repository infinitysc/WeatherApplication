package com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.ReqestAir

import android.util.Log
import com.google.gson.Gson
import com.pallplication.FragA.Network.FinalAirQuiality
import com.pallplication.FragA.Network.OkHttp.OkHttpClientCreator
import com.pallplication.FragA.Network.Retrofit.RetrofitClientCreator
import com.pallplication.FragA.Network.UrlCreator
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class RequestAir{
    class retrofitRequest(map_ : Map<String,String>) {
        private var map : Map<String,String> = map_

        private var result : FinalAirQuiality? = null

        init {
            result = getAir()
        }

        fun returnToActivity() : FinalAirQuiality {
            return this.result!!
        }

        private fun getAir() : FinalAirQuiality {
            return RetrofitClientCreator().getAir(map)
        }
    }

    class okHttpRequest(map_: Map<String, String?>){

        private var classExample : FinalAirQuiality? = null

        private var client = OkHttpClientCreator().getClient()

        private val baseUrl = "https://api.met.no/weatherapi/airqualityforecast/0.1/"

        private var mutMap : MutableMap<String,String>  = mutableMapOf()

        private val url = UrlCreator(baseUrl,mutMap)

        private val requestClient = Request.Builder()
            .url("$url")
            .build()

        @Deprecated("not work")
        private fun request() : FinalAirQuiality?{
            try {
                this.client.newCall(this.requestClient).execute().use {
                    if(!it.isSuccessful){
                        throw IOException("don't work")
                    }
                    return Gson().fromJson(it.body!!.string(),FinalAirQuiality::class.java)
                }
            }
            catch (E_ : IOException){
                Log.e("ErrorInRequestAir","$E_")
                return null
            }
        }
        @Deprecated("not work")
        fun getResultOfClass() : FinalAirQuiality? = this.classExample
    }
}