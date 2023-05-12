package com.example.canapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class AlarmaAseo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarma_aseo)
        val btn_CrearAlarmaAseo : Button = findViewById(R.id.btnCrearAlarmaAseo)
        btn_CrearAlarmaAseo.setOnClickListener()
        {
            Toast.makeText(baseContext, "Alarma de Aseo Exitosa", Toast.LENGTH_SHORT).show()
            val i = Intent(this, Alarmas::class.java)
            startActivity(i)
        }
    }
}