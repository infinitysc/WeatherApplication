package com.pallplication.FragA.Network.DataStorage.Station.sta

import com.google.gson.annotations.SerializedName
import com.pallplication.FragA.Network.DataStorage.Station.sta.NameAreaCode

data class Station(
    val name : String?,
    val eoi : String?,
    val height : Int?,
    @SerializedName("longitude") val longItude : String?,
    @SerializedName("latitude") val latItude : String?,
    val grunnkrets : NameAreaCode,
    val delomrade : NameAreaCode,
    val kommune : NameAreaCode
)
