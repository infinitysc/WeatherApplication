package com.pallplication.FragA.Network

import retrofit2.Call
import retrofit2.http.GET

interface ApInterface {
    @GET("")
    suspend fun getContact() : Call<DataExtClass>

    @GET("")
    suspend fun getClassContact() : DataExtClass
}