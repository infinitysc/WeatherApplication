package com.pallplication.FragA.Network.DataStorage.Station.AirQuiality

import com.google.gson.annotations.SerializedName

data class Location(
    val name : String?,
    val path : String?,
    @SerializedName("areacode") val areaCode : String?,
    val longitude : String?,
    val laltitude : String?,
    @SerializedName("areaclass") val areaClass : String?,
    @SerializedName("superareacode") val superAreaCode : String?
)
