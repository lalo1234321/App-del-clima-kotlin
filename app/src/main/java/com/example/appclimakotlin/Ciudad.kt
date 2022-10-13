package com.example.appclimakotlin

class Ciudad( name:String, weather: ArrayList<Weather>, estatus:String ) {
    var name:String = ""
    var weather:ArrayList<Weather>? = null
    var estatus:String = ""

    init {
        this.name = name
        this.weather = weather
        this.estatus = estatus
    }
}