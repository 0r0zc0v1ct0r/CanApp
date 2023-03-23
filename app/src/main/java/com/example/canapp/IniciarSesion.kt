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

class IniciarSesion : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)
        val btningresar : Button = findViewById(R.id.btnIngresar)
        val txtemail : TextView = findViewById(R.id.edtEmail)
        val txtpass: TextView = findViewById(R.id.edtPassword)
        firebaseAuth= Firebase.auth
        btningresar.setOnClickListener()
        {
            singnIn(txtemail.text.toString(),txtpass.text.toString())
        }
    }

    private fun singnIn(emai: String, password: String)
    {
        firebaseAuth.signInWithEmailAndPassword(emai,password).addOnCompleteListener(this){ task ->
            if(task.isSuccessful){
                val user = firebaseAuth.currentUser
                Toast.makeText(baseContext,"Autentificación Exitosa", Toast.LENGTH_SHORT).show()
                //aqui vamos a ir a la segunda acivity
                val  i = Intent( this, PantallaInicial::class.java)
                startActivity(i)
            }
            else
            {
                Toast.makeText(baseContext, "Error de Email y/o Contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }
}