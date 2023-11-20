package com.example.whatsapplikegavin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsapplikegavin.Repository.UserRepository
import java.sql.SQLException

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Quand on clique sur le bouton, on effectue le findAll de UserRepository
        val button = findViewById<Button>(R.id.RegisterButton)
        button.setOnClickListener {
            try {
                // Créer une instance de UserRepository
                val userRepository = UserRepository()

                // Exécuter la requête findAll
                val preparedStatement = userRepository.findAll()
                println("test: $preparedStatement")
                // Afficher le résultat dans la console (exemple : affichage des noms)

            } catch (e: SQLException) {
                // Gérer les exceptions liées à la base de données
                e.printStackTrace()
            } catch (e: Exception) {
                // Gérer d'autres exceptions
                e.printStackTrace()
            }
        }
    }
}
