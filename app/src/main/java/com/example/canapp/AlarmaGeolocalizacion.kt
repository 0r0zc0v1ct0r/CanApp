package com.example.canapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class AlarmaGeolocalizacion : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarma_geolocalizacion)
        val btn_CrearAlarmaGeolocalizacion : Button = findViewById(R.id.btnCrearAlarmaGeolocalización)
        btn_CrearAlarmaGeolocalizacion.setOnClickListener()
        {
            Toast.makeText(baseContext, "Alarma de Geolocalización Exitosa", Toast.LENGTH_SHORT).show()
            val i = Intent(this, Alarmas::class.java)
            startActivity(i)
        }
    }
}