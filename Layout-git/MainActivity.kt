package com.example.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text:TextView = findViewById(R.id.text)
        val edit1:EditText = findViewById(R.id.edit1)
        val edit2:EditText  =findViewById(R.id.edit2)
        val text1:TextView = findViewById(R.id.text1)
        val text2:TextView = findViewById(R.id.text2)
        val text3:TextView  = findViewById(R.id.text3)
        val button:Button = findViewById(R.id.button)
        val checkBox:CheckBox = findViewById(R.id.check)

        button.setOnClickListener {
            val it:Intent = Intent(this,MainActivity2::class.java)
            startActivity(it)
        }




    }
}