package com.example.appclimakotlin

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

        bMexico.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Ciudad de México", Toast.LENGTH_SHORT).show()
        })
        bBerlin.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Ciudad de Berlin", Toast.LENGTH_SHORT).show()
        })
    }
}