package com.example.canapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class AlarmaAlimentacion : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarma_alimentacion)
        val btn_CrearAlarmaAlimentacion : Button = findViewById(R.id.btnCrearAlarmaAlimentacion)
        btn_CrearAlarmaAlimentacion.setOnClickListener()
        {
            Toast.makeText(baseContext, "Alarma de Alimentacion Exitosa", Toast.LENGTH_SHORT).show()
            val i = Intent(this, Alarmas::class.java)
            startActivity(i)
        }
    }

}