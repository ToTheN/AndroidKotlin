package com.example.signupkotlin

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity2 : AppCompatActivity() {

    companion object{
        private const val CAMERA_PERMISSION_CODE = 100
        private const val STORAGE_PERMISSION_CODE = 101
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        var i:Intent = intent
        val USER =  i.getStringExtra("id_user")
        val EMAIL = i.getStringExtra("id_mail")
        val PHONE = i.getStringExtra("id_phone")
        val PASS = i.getStringExtra("id_password")

        val usertext = findViewById<TextView>(R.id.text1).apply {
            text = USER.toString()
        }
        val mailtext = findViewById<TextView>(R.id.text2).apply{
            text = EMAIL.toString()
        }
        val phonetext = findViewById<TextView>(R.id.text3).apply {
            text = PHONE.toString()
        }
        val passwordtext = findViewById<TextView>(R.id.text4).apply {
            text = PASS.toString()
        }


        val edittext = findViewById<EditText>(R.id.edit_url)
        val button2  = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button2.setOnClickListener {
            checkPermission(Manifest.permission.CAMERA,
                CAMERA_PERMISSION_CODE)
        }

        button3.setOnClickListener {
           val url = edittext.text.toString()
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse(url))
            startActivity(intent)
        }

    }

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
            // Requesting the permission
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                   permissions: Array<String>,
                                   grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
            }
        } else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}