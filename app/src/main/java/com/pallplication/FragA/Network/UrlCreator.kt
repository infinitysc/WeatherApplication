package com.pallplication.FragA.Network

class UrlCreator(baseUrl_ : String,QuerryParams_ : List<String>) {
    private var urlString : String = ""

    init {
        urlString = urlCollector(baseUrl_,QuerryParams_)
    }
    fun getUrlString() : String {
        return this.urlString
    }

    private fun urlCollector(baseUrl_: String,QuerryParams_: List<String>) : String {
        var starStr = baseUrl_
        for (i in QuerryParams_){
            starStr += i
        }
        return starStr
    }
}