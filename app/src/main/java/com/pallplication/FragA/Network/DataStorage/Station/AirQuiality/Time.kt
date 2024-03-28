package com.pallplication.FragA.Network.DataStorage.Station.AirQuiality


import com.google.gson.annotations.SerializedName
import java.security.cert.CertPathValidatorException

data class Time(
    val from : String?,
    @SerializedName("to") val toTime : String?,
    val variables : Variables,
    val reason : CertPathValidatorException.Reason
    )
