package com.st10449069.fluffyspetopia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var etAppName: EditText? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etAppName = findViewById<EditText>(R.id.etAppName)
        val imageView = findViewById<ImageView>(R.id.etBunny)
        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            // call the next screen
            val intent = Intent(this, MainActivity2::class.java)
            // start next activity
            startActivity(intent)
        }
    }
}