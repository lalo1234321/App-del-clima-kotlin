package com.example.appclimakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class Ciudades : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)
        var bMexico = findViewById<Button>(R.id.bMexico)
        var bBerlin = findViewById<Button>(R.id.bBerlin)
        var bApiNode = findViewById<Button>(R.id.bNetworkValidator)
        val TAG = "com.example.appclimakotlin.Ciudades"
        bMexico.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "ciudad-mexico")
            startActivity(intent)
        })
        bBerlin.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "ciudad-berlin")
            startActivity(intent)
        })
        bApiNode.setOnClickListener{
            var intent = Intent(this, User :: class.java)
            intent.putExtra(TAG, "api_node")
            startActivity(intent)
        }
        //24642c88af6ab928c94363e56632a1fd this is my api key for openWeather


        /*if( Network.validateNetwork(this) ) {

            httpRequestVolley("https://api.openweathermap.org/data/2.5/weather?id=3530597&appid=24642c88af6ab928c94363e56632a1fd")
        }else {
            Toast.makeText(this, "No hay red", Toast.LENGTH_SHORT).show()
        }*/

    }


}