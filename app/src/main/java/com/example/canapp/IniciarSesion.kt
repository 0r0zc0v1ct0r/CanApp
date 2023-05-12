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
        val btnCrear_Cuenta: Button = findViewById(R.id.btnCrearCuenta)
        val btnRecordar: TextView = findViewById(R.id.btnOlvidar)
        firebaseAuth= Firebase.auth
        btningresar.setOnClickListener()
        {
            singnIn(txtemail.text.toString(),txtpass.text.toString())
        }
        btnCrear_Cuenta.setOnClickListener()
        {
            val i = Intent(this, CrearCuenta::class.java)
            startActivity(i)
        }
        btnRecordar.setOnClickListener()
        {
            val i = Intent(this, RecordarPass::class.java)
            startActivity(i)
        }
    }

    private fun singnIn(emai: String, password: String)
    {
        firebaseAuth.signInWithEmailAndPassword(emai,password).addOnCompleteListener(this){ task ->
            if(task.isSuccessful){
                val user = firebaseAuth.currentUser
                val verifica = user?.isEmailVerified
                if (verifica==true)
                {


                    Toast.makeText(baseContext, "Autentificación Exitosa", Toast.LENGTH_SHORT)
                        .show()
                    //aqui vamos a ir a la segunda acivity
                    val i = Intent(this, Menu::class.java)
                    startActivity(i)
                }else
                {
                    Toast.makeText(baseContext, "no ha verificado su correo", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(baseContext, "Error de Email y/o Contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }

}