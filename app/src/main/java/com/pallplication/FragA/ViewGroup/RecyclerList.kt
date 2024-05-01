package com.pallplication.FragA.ViewGroup


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Variables
import com.pallplication.FragA.R

class RecyclerList(listVar : List<Variables>, list_ : List<String>,) : RecyclerView.Adapter<RecyclerList.ViewHolder>() {

    private var mListVariables : List<String> = listOf(

        "${listVar[0].AQI?.value}${listVar[0].AQI?.units}",
        "${listVar[0].AQI_no2?.value}${listVar[0].AQI_no2?.units}",
        "${listVar[0].AQI_o3?.value}${listVar[0].AQI_o3?.units}",
        "${listVar[0].AQI_pm10?.value}${listVar[0].AQI_pm10?.units}",
        "${listVar[0].AQI_pm25?.value}${listVar[0].AQI_pm25?.units}",

        "${listVar[0].air0m?.value}${listVar[0].air0m?.units}",
        "${listVar[0].air2m?.value}${listVar[0].air2m?.units}",
        "${listVar[0].air20m?.value}${listVar[0].air20m?.units}",
        "${listVar[0].air100m?.value}${listVar[0].air100m?.units}",
        "${listVar[0].air200m?.value}${listVar[0].air200m?.units}",
        "${listVar[0].air500m?.value}${listVar[0].air500m?.units}",

        "${listVar[0].atmospBoundary?.value}${listVar[0].atmospBoundary?.units}",
        "${listVar[0].cloud?.value}${listVar[0].cloud?.units}",
        "${listVar[0].integral?.value}${listVar[0].integral?.units}",

        "${listVar[0].no2Concentration?.value}${listVar[0].no2Concentration?.units}",
        "${listVar[0].no2LocalHeating?.value}${listVar[0].no2LocalHeating?.units}",
        "${listVar[0].no2LocalIndustry?.value}${listVar[0].no2LocalIndustry?.units}",
        "${listVar[0].no2LocalShipping?.value}${listVar[0].no2LocalShipping?.units}",
        "${listVar[0].no2LocalExhaust?.value}${listVar[0].no2LocalExhaust?.units}",
        "${listVar[0].no2LocalNonExhaust?.value}${listVar[0].no2LocalNonExhaust?.units}",
        "${listVar[0].no2NonLocal?.value}${listVar[0].no2NonLocal?.units}",

        "${listVar[0].o3Concentration?.value}${listVar[0].o3Concentration?.units}",
        "${listVar[0].o3LocalHeating?.value}${listVar[0].o3LocalHeating?.units}",
        "${listVar[0].o3LocalIndustry?.value}${listVar[0].o3LocalIndustry?.units}",
        "${listVar[0].o3LocalShipping?.value}${listVar[0].o3LocalShipping?.units}",
        "${listVar[0].o3LocalExhaust?.value}${listVar[0].o3LocalExhaust?.units}",
        "${listVar[0].o3LocalNonExhaust?.value}${listVar[0].o3LocalNonExhaust?.units}",
        "${listVar[0].o3NonLocal?.value}${listVar[0].o3NonLocal?.units}",

        "${listVar[0].pm10Concentration?.value}${listVar[0].pm10Concentration?.units}",
        "${listVar[0].pm10LocalHeating?.value}${listVar[0].pm10LocalHeating?.units}",
        "${listVar[0].pm10LocalIndustry?.value}${listVar[0].pm10LocalIndustry?.units}",
        "${listVar[0].pm10LocalShipping?.value}${listVar[0].pm10LocalShipping?.units}",
        "${listVar[0].pm10LocalExhaust?.value}${listVar[0].pm10LocalExhaust?.units}",
        "${listVar[0].pm10LocalNonExhaust?.value}${listVar[0].pm10LocalNonExhaust?.units}",
        "${listVar[0].pm10NonLocal?.value}${listVar[0].pm10NonLocal?.units}",

        "${listVar[0].pm25Concentration?.value}${listVar[0].pm25Concentration?.units}",
        "${listVar[0].pm25LocalHeating?.value}${listVar[0].pm25LocalHeating?.units}",
        "${listVar[0].pm25LocalIndustry?.value}${listVar[0].pm25LocalIndustry?.units}",
        "${listVar[0].pm25LocalShipping?.value}${listVar[0].pm25LocalShipping?.units}",
        "${listVar[0].pm25LocalExhaust?.value}${listVar[0].pm25LocalExhaust?.units}",
        "${listVar[0].pm25LocalNonExhaust?.value}${listVar[0].pm25LocalNonExhaust?.units}",
        "${listVar[0].pm25NonLocal?.value}${listVar[0].pm25NonLocal?.units}",

        "${listVar[0].rainfall?.value}${listVar[0].rainfall?.units}",
        "${listVar[0].relativeHumidity?.value}${listVar[0].relativeHumidity?.units}",
        "${listVar[0].showfall?.value}${listVar[0].showfall?.units}",
        "${listVar[0].airPressure?.value}${listVar[0].airPressure?.units}",
        "${listVar[0].windDirection?.value}${listVar[0].windDirection?.units}",
        "${listVar[0].windSpeed?.value}${listVar[0].windSpeed?.units}",
        )
    private val mList = list_
    private val mListOfNames = listOf(
        "AQI",
        "AQI_no2",
        "AQI_O3",
        "AQI_pm10",
        "AQI_pm25",
        "air_temperature_0m",
        "air_temperature_2m",
        "air_temperature_20m",
        "air_temperature_100m",
        "air_temperature_200m",
        "air_temperature_500m",
        "atmosphere_boundary_layer_thickness",
        "cloud_area_fraction",
        "integral_of_surface_net_downward_radiation_flux_wrt_time",
        "no2_concentration",
        "no2_local_fraction_heating",
        "no2_local_fraction_industry",
        "no2_local_fraction_shipping",
        "no2_local_fraction_traffic_exhaust",
        "no2_local_fraction_traffic_nonexhaust",
        "no2_nonlocal_fraction",
        "o3_concentration",
        "o3_local_fraction_heating",
        "o3_local_fraction_industry",
        "o3_local_fraction_shipping",
        "o3_local_fraction_traffic_exhaust",
        "o3_local_fraction_traffic_nonexhaust",
        "o3_nonlocal_fraction",
        "pm10_concentration",
        "pm10_local_fraction_heating",
        "pm10_local_fraction_industry",
        "pm10_local_fraction_shipping",
        "pm10_local_fraction_traffic_exhaust",
        "pm10_local_fraction_traffic_nonexhaust",
        "pm10_nonlocal_fraction",
        "pm25_concentration",
        "pm25_local_fraction_heating",
        "pm25_local_fraction_industry",
        "pm25_local_fraction_shipping",
        "pm25_local_fraction_traffic_exhaust",
        "pm25_local_fraction_traffic_nonexhaust",
        "pm25_nonlocal_fraction",
        "rainfall_amount",
        "relative_humidity_2m",
        "snowfall_amount",
        "surface_air_pressure",
        "wind_direction",
        "wind_speed"

    )

    override fun getItemCount(): Int {
        return mListVariables.size
    }
    fun getItemCountListTime() : Int {
        return mList.size
    }
    fun getItemCountListNames() : Int {
        return mListOfNames.size
    }


    override fun onBindViewHolder(holder: RecyclerList.ViewHolder, position: Int) {



        var name = mListOfNames[position]
        var value = mListVariables[position]


        //first text -> name
        //context Text -> value
        holder.firstText.text = name
        holder.contextTextView.text  = value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerList.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler,parent,false)
        return RecyclerList.ViewHolder(view)
    }

    class ViewHolder(view_ : View) : RecyclerView.ViewHolder(view_){
        val firstText : TextView = view_.findViewById(R.id.nameTextView)
        val contextTextView : TextView = view_.findViewById(R.id.contextTextView)

    }

}
