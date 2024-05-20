package com.example.enzoo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Desafidiario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.desadi)

        val generator = UniqueRandomGenerator()
        val x = generator.generateUniqueNumber(1, 5)

        if (x == 1) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Maratona de Filmes Favoritos:\n" +
                        "Desafio: Faça uma maratona de filmes favoritos juntos.\n" +
                        "Como: Faça uma lista dos filmes favoritos de cada um e assistam juntos durante todo o dia ou a noite. Prepare pipoca, salgadinhos, doces e bebidas para acompanhar a maratona."
        }

        if (x == 2) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Sessão de Degustação de Vinhos e Queijos:\n" +
                        "Desafio: Realize uma sessão de degustação de vinhos e queijos em casa.\n" +
                        "Como: Escolha uma seleção de vinhos e queijos diferentes e experimente-os juntos. Aproveite para discutir os sabores e descobrir novas combinações que vocês gostem. Coloque uma playlist de músicas românticas ao fundo para criar um ambiente agradável."
        }

        if (x == 3) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Noite de Karaokê em Casa:\n" +
                        "Desafio: Organize uma noite de karaokê romântico em casa.\n" +
                        "Como: Monte um sistema de karaokê em casa com um microfone, alto-falantes e um aplicativo de karaokê. Escolha suas músicas românticas favoritas e divirtam-se cantando juntos. Sirva petiscos e bebidas para tornar a noite ainda mais divertida e especial."
        }


        val btnon: Button = findViewById(R.id.btndica)
        btnon.setOnClickListener{
            val intent = Intent(this@Desafidiario, Dica::class.java)
            startActivity(intent)

        }
        val btnone: Button = findViewById(R.id.enviar)
        btnone.setOnClickListener{
            val intent = Intent(this@Desafidiario, Diario::class.java)
            startActivity(intent)

        }


    }



    class UniqueRandomGenerator {
        private val generatedNumbers = mutableListOf<Int>()

        fun generateUniqueNumber(min: Int, max: Int): Int {
            var randomNumber: Int
            do {
                randomNumber = Random.nextInt(min, max + 1)
            } while (generatedNumbers.contains(randomNumber))

            generatedNumbers.add(randomNumber)
            return randomNumber
        }
    }
}




