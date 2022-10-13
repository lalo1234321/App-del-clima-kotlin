package com.example.appclimakotlin

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity

class Network {
    companion object {
        fun validateNetwork(activity: AppCompatActivity):Boolean {
            var connectivity = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var networkInfo =connectivity.activeNetworkInfo
            return ( networkInfo != null && networkInfo.isConnected )
        }
    }
}