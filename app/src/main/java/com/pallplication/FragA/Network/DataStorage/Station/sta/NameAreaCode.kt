package com.pallplication.FragA.Network.DataStorage.Station.sta

import com.google.gson.annotations.SerializedName

data class NameAreaCode(
    val name : String?,
    @SerializedName("areacode") val areaCode : Int?
)
