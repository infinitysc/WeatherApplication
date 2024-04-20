package com.pallplication.FragA.Network.Retrofit

import com.pallplication.FragA.Network.DataStorage.Station.sta.Station
import com.pallplication.FragA.Network.FinalAirQuiality
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface ApInterface {
    @GET("stations")
    suspend fun getDataClass() : List<Station>

    @GET("?")
    suspend fun getAirClass(@QueryMap mapped_ : Map<String,String>) :  FinalAirQuiality
}