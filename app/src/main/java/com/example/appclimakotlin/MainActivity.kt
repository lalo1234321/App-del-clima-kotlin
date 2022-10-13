package com.example.appclimakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    var tvGrados:TextView? = null
    var tvCiudad:TextView? = null
    var tvEstatus:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvGrados = findViewById<TextView>(R.id.textView3)
        tvCiudad = findViewById<TextView>(R.id.textView2)
        tvEstatus = findViewById<TextView>(R.id.textView4)
        var ciudad = intent.getStringExtra("com.example.appclimakotlin.Ciudades")

        /*var ciudadMexico = Ciudad("Ciudad de México", 50, "Caluroso")
        var ciudadBerlin = Ciudad("Ciudad de Berlin", 80, "Nublado")
        //Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()*/
        if( ciudad == "ciudad-mexico" ) {
            if( Network.validateNetwork( this ) ){
                httpRequestVolley("https://api.openweathermap.org/data/2.5/weather?id=3530597&appid=24642c88af6ab928c94363e56632a1fd&units=metric&lang=es")
            }
        }
        /*else if( ciudad == "ciudad-berlin" ) {
            if( Network.validateNetwork( this ) ){
                httpRequestVolley("https://api.openweathermap.org/data/2.5/weather?id=2950159&appid=24642c88af6ab928c94363e56632a1fd&units=metric&lang=es")
            }
        }*/
        else if( ciudad == "api_node" ) {

        }
        else {
            Toast.makeText(this, "El dato no se encuentra", Toast.LENGTH_SHORT).show()
        }

    }

    private fun httpRequestVolley( url:String ) {
        //this library act like a queue, we can manage many http requests
        var queue = Volley.newRequestQueue(this)
        //StringRequests return a result in string format
        var request = StringRequest(Request.Method.GET,url, Response.Listener<String>{
                response ->
            try {
                //code to process request
                var temperatureCelsius:Double?
                var gson = Gson()
                var ciudad = gson.fromJson(response, Ciudad :: class.java)
                //at this point i have mapped the info with gson, and a Ciudad object has been created with the correct
                tvCiudad?.text = ciudad.name
                //temperatureCelsius = ciudad.main?.temp
                //temperatureCelsius = temperatureCelsius  - 273.15
                tvGrados?.text = ciudad.main?.temp.toString()
                tvEstatus?.text = ciudad.weather?.get(0)?.description.toString()

                println(response)
            } catch ( e:Exception ){
                print(e)
            }
        }, Response.ErrorListener{

        })
        queue.add(request)
    }
}