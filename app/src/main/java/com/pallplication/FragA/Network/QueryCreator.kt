package com.pallplication.FragA.Network

class QueryCreator(_baseParamsList : List<String>?) {
    private var empty = ""
    private val listOfParams = listOf("reftime","lat","lon","areaclass","station","show","filter_vars")
    init {
       // empty =constructorString(_baseParamsList)
    }
    /**
     * или в конструктор класса добавить параметры=значение и дальше пушить либо
     * принимать значения типа map(Параметр: значение) и уже создавать строку
    **/
    /*private fun constructorString(_baseParamsList: List<String>?) : Unit {
        if(_baseParamsList == null ){
            //return ""
        }
        var baseString ="?"
        var i = 0
        var j = 0
        while( i < _baseParamsList.size){
            if (_baseParamsList[i] == listOfParams[j]){

            }
        }
    }
    fun getString(): String {
        return this.empty
    }*/
}