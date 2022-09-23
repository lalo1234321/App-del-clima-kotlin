package com.example.appclimakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var ciudad = intent.getStringExtra("com.example.appclimakotlin.Ciudades")
        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()
    }
}