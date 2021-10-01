package com.example.signupkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val username = findViewById<EditText>(R.id.edt_User_name)
        val email = findViewById<EditText>(R.id.edt_email)
        val phone = findViewById<EditText>(R.id.edt_phone)
        val password = findViewById<EditText>(R.id.edt_password)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val user = username.text.toString()
            val mail = email.text.toString()
            val no = phone.text.toString()
            val pass = password.text.toString()

            if((TextUtils.isEmpty(user)) or (TextUtils.isEmpty(mail)) or (TextUtils.isEmpty(no)) or (TextUtils.isEmpty(pass)))
            {
                Toast.makeText(this, "please enter details",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,MainActivity2::class.java).also {
                    it.putExtra("id_user",user)
                    it.putExtra("id_mail",mail)
                    it.putExtra("id_phone",no)
                    it.putExtra("id_password",pass)
                    startActivity(it)
                }


            }
        }
    }
}