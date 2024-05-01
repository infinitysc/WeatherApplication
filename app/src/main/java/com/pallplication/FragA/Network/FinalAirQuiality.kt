package com.pallplication.FragA.Network

import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Data
import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Meta
import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Time
import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Variables


data class FinalAirQuiality(
    private val meta : Meta,
    private val data : Data
    ) {
    fun getData() : Data = data

    private fun getListTimeFromData() : List<Time> = data.time


    fun getFromAndTime() : List<List<String?>> {
        return mutableListOf<MutableList<String?>>().also {mutIt : MutableList<MutableList<String?>> ->
            getListTimeFromData().forEach(){timeIt : Time ->
                mutIt.add(mutableListOf<String?>().also {
                    it.add(timeIt.from)
                    it.add(timeIt.toTime)
                })
            }
        }
    }
    fun getVariables() : List<List<Variables>>{
        return mutableListOf<MutableList<Variables>>().also {mutIt : MutableList<MutableList<Variables>> ->
            getListTimeFromData().forEach(){timeIt : Time ->
                mutIt.add(mutableListOf<Variables>().also {
                    it.add(timeIt.variables)
                })
            }
        }
    }

}
