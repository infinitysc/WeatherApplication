package com.pallplication.FragA.Network

class UrlCreator(baseUrl_ : String,QueryParams_ : List<String?>) {
    private var urlString : String = ""
    private val startQuery = "?"
    private val unionQuery = "&"
    private val listOfParams = listOf("reftime","lat","lon","areaclass","station","show","filter_vars")
    private lateinit var mapping : Map<String, String?>
    private var mapString = ""
    init {
        urlString = urlCollector(baseUrl_,QueryParams_)
    }
    fun getUrlString() : String {
        return this.urlString
    }

    private fun urlCollector(baseUrl_: String,QueryParams_: List<String?>) : String {
        var starStr = "$baseUrl_"
        var counter = 0
        for (i in 0..QueryParams_.size-1){
            if(QueryParams_[i]!= null){
                counter+=1
                starStr = if(counter == 1) {
                    "$starStr${listOfParams[i]}=${QueryParams_[i]}"
                }
                else{
                    "$starStr&${listOfParams[i]}=${QueryParams_[i]}"
                }
            }
        }
        return starStr
    }

    constructor(baseUrl_: String,map_ : Map<String,String?>) : this(baseUrl_,listOf()){
        mapping = map_
        mapString = urlCollectorMap(baseUrl_,map_)
    }
    private fun urlCollectorMap(baseUrl_: String,map_ : Map<String,String?>) : String{
        var startStr = "$baseUrl_?"
        var counter = 0
        map_.forEach(){
            if(it.value != null){
                counter += 1
                startStr = if(counter == 1){
                    "$startStr${it.key}=${it.value}"
                }
                else{
                    "$startStr&${it.key}=${it.value}"
                }
            }
        }
        return startStr
    }
    public fun mappedString() : String {
        return this.mapString
    }
}