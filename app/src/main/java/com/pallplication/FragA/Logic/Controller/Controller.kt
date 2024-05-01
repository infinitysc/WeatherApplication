package com.pallplication.FragA.Logic.Controller

import android.graphics.ColorSpace
import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.ReqestAir.RequestAir
import com.pallplication.FragA.Network.FinalAirQuiality

class Controller() {

    private var controller : Controller? = null
    private var stationString : String? = null
    private var lan : String? = null
    private var lon : String? = null
    private var areaclass : String? = null
    private var dataClass : FinalAirQuiality? = null

    constructor(lan_ : String? , lon_ : String? ,areaclass_: String?) :  this(){
        lan = lan_
        lon = lon_
        areaclass = areaclass_
        //model = Model(returnModelFFA(lan,lon,areaclass))
        dataClass = returnModelFFA(lan,lon,areaclass)
    }
    constructor(areaclass_: String?,station_ : String?) : this() {
        areaclass = areaclass_
        stationString = station_
        //model = Model(returnModelAS(areaclass,station_))
        dataClass = returnModelAS(areaclass,stationString)
    }

    constructor(station_: String?) : this(){
        stationString = station_
        //model = Model(returnModelS(stationString))
        dataClass = returnModelS(stationString)
    }

    private fun returnModelFFA(lat : String?,lon : String?,areaclass : String?) : FinalAirQuiality{ // area lat lon
        val maps : Map<String,String> = mapOf("areaclass" to areaclass.let {
            when(it!=null){
                true -> areaclass!!
                false -> ""
            }
        },"lat" to lat.let {
            when(it!=null){
                true -> lat!!
                false -> "0"
            }

        },"lon" to lon.let {
            when(it!=null){
                true -> lon!!
                false -> "0"
            }
        }
        )

        return RequestAir.retrofitRequest(maps).returnToActivity()
    } // not tested
    private fun returnModelAS(area : String?,station : String?) : FinalAirQuiality{
        val trueArea = area.let {
            when(it!=null){
                true -> area!!
                false -> ""
            }
        }
        val trueString = station.let {
            when(it!=null){
                true -> station!!
                false ->""
            }
        }
        val maps : Map<String,String> = mapOf("areaclass" to trueArea,"station" to trueString)
        return RequestAir.retrofitRequest(maps).returnToActivity()
    } // not tested
    private fun returnModelS(station : String?) : FinalAirQuiality{
        val trueString = station.let {
            when(it!=null){
                true -> station!!
                false ->""
            }
        }
        val maps : Map<String,String> = mapOf("station" to trueString)
        return RequestAir.retrofitRequest(maps).returnToActivity()
    } // not tested

    fun getData() : FinalAirQuiality = this.dataClass!!
}