package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val clmain = findViewById<ConstraintLayout>(R.id.main)

        // Botón 1 - Toast
        val btnMessage1: Button = findViewById(R.id.button)
        btnMessage1.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.TextMessage1),
                Toast.LENGTH_LONG
            ).show()
        }

        // Clase para el click del Snackbar
        class SnackbarClick : View.OnClickListener {
            override fun onClick(p0: View?) {
                Snackbar.make(clmain, "Cancelled action", Snackbar.LENGTH_SHORT).show()
            }
        }

        // Botón 2 - Snackbar
        val btnMessage2: Button = findViewById(R.id.button2)
        btnMessage2.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.TextMessage1),
                Toast.LENGTH_LONG
            ).show()

            val mySnackbar = Snackbar.make(clmain, R.string.TextMessage2, Snackbar.LENGTH_LONG)
            mySnackbar.setAction(R.string.TextSnackbar, SnackbarClick())
            mySnackbar.show()
        }

        // Botón 3 - Abrir Pantalla
        val btnOpenScreen: Button = findViewById(R.id.button3)
        btnOpenScreen.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.btnTextOpenScreen_main),
                Toast.LENGTH_LONG
            ).show()

            val intent = Intent(this, SecondActivity2::class.java)
            startActivity(intent)
        }
    }
}