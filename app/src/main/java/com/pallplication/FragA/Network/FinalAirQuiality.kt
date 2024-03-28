package com.pallplication.FragA.Network

import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Data
import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Meta


class FinalAirQuiality(private val meta : Meta, private val data : Data){
    fun getMeta() : Meta {return this.meta}
    fun getData() : Data {return this.data}
}
