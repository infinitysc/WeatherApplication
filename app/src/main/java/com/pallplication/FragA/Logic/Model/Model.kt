package com.pallplication.FragA.Logic.Model

import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Meta
import com.pallplication.FragA.Network.FinalAirQuiality
import java.io.IOException

class Model(
    private val data : FinalAirQuiality,
)
{

    private val trueData = data
    private var mutedList = mutableListOf<Any>()

    private fun scopeList(){
        data.data.time.forEach(){
            mutedList.add(it)
        }
    }




}