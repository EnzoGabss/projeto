package com.example.enzoo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.enzoo.models.DiarioModelo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Diario: AppCompatActivity() {
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diario)

        val btnon: Button = findViewById(R.id.button4)
        btnon.setOnClickListener{
            dbRef = FirebaseDatabase.getInstance().getReference("diarios")

            val feed = findViewById<EditText>(R.id.textfeedback).text.toString()

            val dispId = dbRef.push().key?: ""


            val dispositivosss = DiarioModelo(dispId, feed)

            dbRef.child(dispId).setValue(dispositivosss)
                .addOnCompleteListener{
                    Toast.makeText(this,"Dado inserido com sucesso", Toast.LENGTH_SHORT).show()

                }.addOnFailureListener{ err->
                    Toast.makeText(this,"Erro ${err.message}", Toast.LENGTH_SHORT).show()
                }



            val intent = Intent(this@Diario, Layout::class.java)
            startActivity(intent)

        }

    }
}