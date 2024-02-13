package com.example.entregafinalpsp.superHeroApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.entregafinalpsp.R
import com.example.entregafinalpsp.databinding.ActivityAuthBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLogin()
    }

    private fun initLogin() {
        binding.signUpButton.setOnClickListener {
            if (binding.username.text.isNotEmpty() && binding.password.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.username.text.toString(),
                    binding.password.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showAlertOk()
                    } else {
                        showAlertFail()
                    }
                }.addOnFailureListener {
                    it.message?.let { it1 -> Log.i("error", it1) }
                }
            }
        }
        binding.loginButton.setOnClickListener {
            if (binding.username.text.isNotEmpty() && binding.password.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    binding.username.text.toString(),
                    binding.password.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        navigateToHome()
                    } else {
                        showAlertFail()
                    }
                }
            }
        }
    }

    private fun showAlertFail() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        var dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showAlertOk() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("OK")
        builder.setMessage("Se ha registrado al usuario con éxito")
        builder.setPositiveButton("Aceptar", null)
        var dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun navigateToHome(){
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }
}