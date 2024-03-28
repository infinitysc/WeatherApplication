package com.pallplication.FragA.Network.DataStorage.Station.AirQuiality


import com.google.gson.annotations.SerializedName

data class Variables(
    //AQi
    val AQI : UnitValueClass?,
    val AQI_no2 : UnitValueClass?,
    val AQI_o3 : UnitValueClass?,
    val AQI_pm10 : UnitValueClass?,
    val AQI_pm25 : UnitValueClass?,
    //Temperature air
    @SerializedName("air_temperature_0m") val air0m: UnitValueClass?,
    @SerializedName("air_temperature_100m") val air100m: UnitValueClass?,
    @SerializedName("air_temperature_200m") val air200m: UnitValueClass?,
    @SerializedName("air_temperature_20m") val air20m: UnitValueClass?,
    @SerializedName("air_temperature_2m") val air2m: UnitValueClass?,
    @SerializedName("air_temperature_500m") val air500m: UnitValueClass?,
    //
    @SerializedName("atmosphere_boundary_layer_thickness") val atmospBoundary: UnitValueClass?,
    @SerializedName("cloud_area_fraction") val cloud: UnitValueClass?,
    @SerializedName("integral_of_surface_net_downward_radiation_flux_wrt_time") val integral: UnitValueClass?,
    //no2
    @SerializedName("no2_concentration") val no2Concentration: UnitValueClass?,
    @SerializedName("no2_local_fraction_heating") val no2LocalHeating: UnitValueClass?,
    @SerializedName("no2_local_fraction_industry") val no2LocalIndustry: UnitValueClass?,
    @SerializedName("no2_local_fraction_shipping") val no2LocalShipping: UnitValueClass?,
    @SerializedName("no2_local_fraction_traffic_exhaust") val no2LocalExhaust: UnitValueClass?,
    @SerializedName("no2_local_fraction_traffic_nonexhaust") val no2LocalNonExhaust: UnitValueClass?,
    @SerializedName("no2_nonlocal_fraction") val no2NonLocal: UnitValueClass?,
    //o3
    @SerializedName("o3_concentration") val o3Concentration: UnitValueClass?,
    @SerializedName("o3_local_fraction_heating") val o3LocalHeating: UnitValueClass?,
    @SerializedName("o3_local_fraction_industry") val o3LocalIndustry: UnitValueClass?,
    @SerializedName("o3_local_fraction_shipping") val o3LocalShipping: UnitValueClass?,
    @SerializedName("o3_local_fraction_traffic_exhaust") val o3LocalExhaust: UnitValueClass?,
    @SerializedName("o3_local_fraction_traffic_nonexhaust") val o3LocalNonExhaust: UnitValueClass?,
    @SerializedName("o3_nonlocal_fraction") val o3NonLocal: UnitValueClass?,
    //pm10
    @SerializedName("pm10_concentration") val pm10Concentration: UnitValueClass?,
    @SerializedName("pm10_local_fraction_heating") val pm10LocalHeating: UnitValueClass?,
    @SerializedName("pm10_local_fraction_industry") val pm10LocalIndustry: UnitValueClass?,
    @SerializedName("pm10_local_fraction_shipping") val pm10LocalShipping: UnitValueClass?,
    @SerializedName("pm10_local_fraction_traffic_exhaust") val pm10LocalExhaust: UnitValueClass?,
    @SerializedName("pm10_local_fraction_traffic_nonexhaust") val pm10LocalNonExhaust: UnitValueClass?,
    @SerializedName("pm10_nonlocal_fraction") val pm10NonLocal: UnitValueClass?,
    //pm25
    @SerializedName("pm25_concentration") val pm25Concentration: UnitValueClass?,
    @SerializedName("pm25_local_fraction_heating") val pm25LocalHeating: UnitValueClass?,
    @SerializedName("pm25_local_fraction_industry") val pm25LocalIndustry: UnitValueClass?,
    @SerializedName("pm25_local_fraction_shipping") val pm25LocalShipping: UnitValueClass?,
    @SerializedName("pm25_local_fraction_traffic_exhaust") val pm25LocalExhaust: UnitValueClass?,
    @SerializedName("pm25_local_fraction_traffic_nonexhaust") val pm25LocalNonExhaust: UnitValueClass?,
    @SerializedName("pm25_nonlocal_fraction") val pm25NonLocal: UnitValueClass?,
    //
    @SerializedName("rainfall_amount") val rainfall: UnitValueClass?,
    @SerializedName("relative_humidity_2m") val relativeHumidity: UnitValueClass?,
    @SerializedName("snowfall_amount") val showfall: UnitValueClass?,
    @SerializedName("surface_air_pressure") val airPressure: UnitValueClass?,
    @SerializedName("wind_direction") val windDirection: UnitValueClass?,
    @SerializedName("wind_speed") val windSpeed: UnitValueClass?,
)
