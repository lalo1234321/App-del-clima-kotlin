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

class Ciudades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)
        var bMexico = findViewById<Button>(R.id.bMexico)
        var bBerlin = findViewById<Button>(R.id.bBerlin)
        var bValidateNetWork = findViewById<Button>(R.id.bNetworkValidator)
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

        bValidateNetWork.setOnClickListener{
            if( Network.validateNetwork(this) ) {
                Toast.makeText(this, "Hay conexión", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "No hay red", Toast.LENGTH_SHORT).show()
            }
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
                println(response)
            } catch ( e:Exception ){
                print(e)
            }
        }, Response.ErrorListener{

        })
        queue.add(request)
    }
}