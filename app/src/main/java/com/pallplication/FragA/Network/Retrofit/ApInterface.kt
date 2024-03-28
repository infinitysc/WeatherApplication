package com.pallplication.FragA.Network.Retrofit

import com.pallplication.FragA.Network.FinalAirQuiality
import retrofit2.Call
import retrofit2.http.GET

interface ApInterface {
    @GET("")
    suspend fun getDataClass() : FinalAirQuiality?
}