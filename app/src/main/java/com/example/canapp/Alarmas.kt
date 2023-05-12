package com.example.canapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Alarmas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarmas)
        val btn_AlimentacionA : Button = findViewById(R.id.btnAlimentacionA)
        val btn_GeolocalizacionA : Button = findViewById(R.id.btnGeolocalizacionA)
        val btn_AseoA : Button = findViewById(R.id.btnAseoA)
        btn_AlimentacionA.setOnClickListener()
        {
            val i = Intent(this, AlarmaAlimentacion::class.java)
            startActivity(i)
        }
        btn_GeolocalizacionA.setOnClickListener()
        {
            val i = Intent(this, AlarmaGeolocalizacion::class.java)
            startActivity(i)
        }
        btn_AseoA.setOnClickListener()
        {
            val i = Intent(this, AlarmaAseo::class.java)
            startActivity(i)
        }
    }
}