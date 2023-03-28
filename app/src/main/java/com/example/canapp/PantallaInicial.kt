package com.example.canapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset

class PantallaInicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_inicial)
        
        val gson = Gson()
        val json = loadData(inFile = "personas.json")
        val persona = gson.fromJson(json, Response::class.java)

        Log.d("RES", persona.grupo)

    }

    fun loadData(inFile: String): String {
        var tContents = ""
        try{
            val stream = assets.open(inFile)
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            tContents = String(buffer)
        } catch (e: IOException){
            // Handle exceptions here
        }
        return tContents
    }

}


