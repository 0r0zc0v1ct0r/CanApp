package com.example.canapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecordarPass : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordar_pass)
        val txtmail : TextView = findViewById(R.id.txtEmailCambio)
        val btnCambiar : Button = findViewById(R.id.btnCambiar)
        btnCambiar.setOnClickListener()
        {
            sendPasswordReset(txtmail.text.toString())
        }



        firebaseAuth= Firebase.auth
    }
    private fun sendPasswordReset (email: String)
    {
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener()
        { task ->
            if (task.isSuccessful)
            {
                Toast.makeText(baseContext, "Correo de cambio de Contraseña Enviado", Toast.LENGTH_SHORT).show()
                val  i = Intent( this, IniciarSesion::class.java)
                startActivity(i)
            }
            else
            {
                Toast.makeText(baseContext,"Error, no se pudo completar completar el proceso", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        return
    }
}