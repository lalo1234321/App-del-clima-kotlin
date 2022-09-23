package com.example.appclimakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

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
        var ciudadMexico = Ciudad("Ciudad de México", 50, "Caluroso")
        var ciudadBerlin = Ciudad("Ciudad de Berlin", 80, "Nublado")
        //Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()
        if( ciudad == "ciudad-mexico" ) {
            tvEstatus?.text = ciudadMexico.estatus
            tvCiudad?.text = ciudadMexico.nombre
            tvGrados?.text = ciudadMexico.grados.toString() + "°"
        }
        else if( ciudad == "ciudad-berlin" ) {
            tvEstatus?.text = ciudadBerlin.estatus
            tvCiudad?.text = ciudadBerlin.nombre
            tvGrados?.text = ciudadBerlin.grados.toString() + "°"
        }else {
            Toast.makeText(this, "El dato no se encuentra", Toast.LENGTH_SHORT).show()
        }

    }
}