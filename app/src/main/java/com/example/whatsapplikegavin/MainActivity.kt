package com.example.whatsapplikegavin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsapplikegavin.Repository.UserRepository

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //quand on clique sur le bouton on effectue le findAll de UserRepository
        val button = findViewById<Button>(R.id.RegisterButton)
        button.setOnClickListener {
            //afficher le resultat dans la console
            val userRepository = UserRepository()

            // Exécuter la requête findAll
            val result = userRepository.findAll()

            // Afficher le résultat sur l'écran
            //println(result)

        }

    }
}