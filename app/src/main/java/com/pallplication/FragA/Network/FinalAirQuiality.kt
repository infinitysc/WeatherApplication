package com.pallplication.FragA.Network

import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Data
import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Meta


data class FinalAirQuiality(
    val meta : Meta,
    val data : Data
    ) {}
