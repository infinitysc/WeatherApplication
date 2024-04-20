package com.pallplication.FragA.Network.DataStorage.Station.AirQuiality


import com.google.gson.annotations.SerializedName

data class Meta(
    val reftime : String?,
    val location : Location,
    @SerializedName("superlocation") val superLocation : Location,
    @SerializedName("sublocations") val subLocations : List<Location>
)
