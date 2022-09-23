package com.example.appclimakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)
        var bMexico = findViewById<Button>(R.id.bMexico)
        var bBerlin = findViewById<Button>(R.id.bBerlin)
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
    }
}