package com.example.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val card1: CardView = findViewById(R.id.card1)

        card1.setOnClickListener {
            val it: Intent = Intent(this, MainActivity3::class.java)
            startActivity(it)

        }
    }
}