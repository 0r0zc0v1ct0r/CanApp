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

class CrearCuenta : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)
        val btningresar_nuevo : Button = findViewById(R.id.btnCambiar)
        val txtnombre_nuevo : TextView = findViewById(R.id.edtNombreN)
        val txtemail_nuevo : TextView = findViewById(R.id.edtEmailN)
        val txtpasswod1 : TextView = findViewById(R.id.edtPasswordN)
        val txtpasswod2 : TextView = findViewById(R.id.edtPasswordNc)

        val btnCrea_CuentaNueva : Button = findViewById(R.id.btnCrearCuentaN)

        btningresar_nuevo.setOnClickListener()
        {
            val i = Intent(this, IniciarSesion::class.java)
            startActivity(i)
        }

        btnCrea_CuentaNueva.setOnClickListener()
        {
            var pass1 = txtpasswod1.text.toString()
            var pass2 = txtpasswod2.text.toString()
            if(pass1.equals(pass2))
            {
                createAccount(txtemail_nuevo.text.toString(),txtpasswod1.text.toString())
            }
            else
            {
                Toast.makeText(baseContext, "Error: la contraseña no conciden",Toast.LENGTH_SHORT).show()
                txtpasswod1.requestFocus()
            }
        }






        firebaseAuth= Firebase.auth
    }
    private fun createAccount(email: String,password: String)
    {
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){ task ->
            if(task.isSuccessful)
            {
                sendEmailVerification()
                Toast.makeText(baseContext,"Cuenta creada Correctamente, se requiere Verificación", Toast.LENGTH_SHORT).show()
                val  i = Intent( this, IniciarSesion::class.java)
                startActivity(i)
            }
            else
            {
                Toast.makeText(baseContext,"Algo salio mal, Error: " + task.exception, Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun sendEmailVerification()
    {
        val user = firebaseAuth.currentUser!!
        user.sendEmailVerification().addOnCompleteListener(this){ task ->
            if(task.isSuccessful)
            {

            }
            else
            {

            }
        }
    }


}