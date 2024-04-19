package com.pallplication.FragA.Network.DataStorage.Station.sta.RequestStat

import android.util.Log
import com.google.gson.Gson
import com.pallplication.FragA.Network.DataStorage.Station.sta.Station
import com.pallplication.FragA.Network.OkHttp.OkHttpClientCreator
import com.pallplication.FragA.Network.Retrofit.RetrofitClientCreator
import com.pallplication.FragA.Network.UrlCreator
import kotlinx.coroutines.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class RequestStation {

    class RetrofitRequest() {

        private var listStation = trueWork()

        private fun trueWork(): List<Station> {
            return RetrofitClientCreator().getApi()
        }
        fun getList(): List<Station> {return this.listStation}

    }

    @Deprecated("call.enqueue is not working")
    class okHttpRequest() {
        private val client = OkHttpClientCreator().getClient()

        private val baseUrl = "https://api.met.no/weatherapi/airqualityforecast/0.1/stations"

        private val url = UrlCreator(baseUrl,"station")

        private var requestStation = Request.Builder()
            .url(baseUrl)
            .build()

        var listStation = null
        @Deprecated("not work")
        private suspend fun request() : List<Station>? {
            var mutedList: MutableList<Station>? = null
            val b = client.newCall(requestStation)
            b.enqueue(
                object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        e.printStackTrace()
                        mutedList = mutableListOf()
                    }

                    override fun onResponse(call: Call, response: Response) {
                        response.use {
                            if (!it.isSuccessful) {
                                throw IOException("some message")
                            }
                            mutedList =
                                Gson().fromJson(response.body!!.string(), Array<Station>::class.java)
                                    .toMutableList()
                        }
                    }
                }
                ,)
            return mutedList
            // Gson().fromJson(it.body!!.string(),Array<Station>::class.java).toList()
        }
        @Deprecated("not work")
        suspend fun requesTest() : List<Station>? {
            var mutedList: MutableList<Station>? = null
            val b = client.newCall(requestStation)
            b.enqueue(
                object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        e.printStackTrace()
                        mutedList = mutableListOf()
                    }

                    override fun onResponse(call: Call, response: Response) {
                        response.use {
                            if (!it.isSuccessful) {
                                throw IOException("some message")
                            }
                            mutedList =
                                Gson().fromJson(response.body!!.string(), Array<Station>::class.java)
                                    .toMutableList()
                        }
                    }
                }
                ,)
            return mutedList
            // Gson().fromJson(it.body!!.string(),Array<Station>::class.java).toList()
        }

        @Deprecated("notWorkFunction")
        private fun syncRequest() : List<Station>?{
            try {
                client.newCall(requestStation).execute().use {
                    if(!it.isSuccessful){
                        throw IOException("some code")
                    }
                    return Gson().fromJson(it.body!!.string(),Array<Station>::class.java).toList()
                }
            }
            catch (E_:IOException){
                return null
            }
        }

        @Deprecated("not need")
        fun getResultOfClass() : List<Station> {
            return try {
                if(this.listStation == null){
                    throw java.lang.NullPointerException("getResultOfClass null exception")
                }
                this.listStation!!
            } catch (E_ : java.lang.NullPointerException){
                Log.e("nullPointerException","$E_")
                listOf<Station>()
            }
        }

    }
}