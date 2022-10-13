package com.example.appclimakotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class User:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        if( Network.validateNetwork( this ) ) {
            httpRequestVolley("http://10.230.2.22:3005/getUser")
        }
    }
    private fun httpRequestVolley( url:String ) {
        //this library act like a queue, we can manage many http requests
        var queue = Volley.newRequestQueue(this)
        //StringRequests return a result in string format
        var request = StringRequest(Request.Method.GET,url, Response.Listener<String>{
                response ->
            try {

                println("antes de la peticion a node")
                println(response)
            } catch ( e:Exception ){
                print(e)
            }
        }, Response.ErrorListener{

        })
        queue.add(request)
    }
}