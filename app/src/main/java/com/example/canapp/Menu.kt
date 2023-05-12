package com.example.canapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btn_Alimentacion : Button = findViewById(R.id.btnAlarmas)
        val btn_Geolocalizacion : Button = findViewById(R.id.btnGeolocalizacion)
        val btn_Perfiles : Button = findViewById(R.id.btnPerfiles)
        btn_Alimentacion.setOnClickListener()
        {
            val i = Intent(this, Alarmas::class.java)
            startActivity(i)
        }
        btn_Geolocalizacion.setOnClickListener()
        {
            val i = Intent(this, Geolocalizacion::class.java)
            startActivity(i)
        }
        btn_Perfiles.setOnClickListener()
        {
            val i = Intent(this, PantallaInicial::class.java)
            startActivity(i)
        }
    }
}