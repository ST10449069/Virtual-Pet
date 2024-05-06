package com.st10449069.fluffyspetopia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private var pet = Pet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val feedTextView = findViewById<TextView>(R.id.tvFeed)
        val cleanTextView = findViewById<TextView>(R.id.tvClean)
        val playTextView = findViewById<TextView>(R.id.tvPlay)
        val imageView = findViewById<ImageView>(R.id.imageView)

        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnClean = findViewById<Button>(R.id.btnClean)
        val btnExit = findViewById<Button>(R.id.btnExit)


        btnFeed.setOnClickListener {
            pet.feed()
            imageView.setImageResource(R.drawable.imad11)
            updatePetStatusText(feedTextView, cleanTextView, playTextView)
        }

        btnPlay.setOnClickListener {
            pet.play()
            imageView.setImageResource(R.drawable.imad1)
            updatePetStatusText(feedTextView, cleanTextView, playTextView)
        }

        btnClean.setOnClickListener {
            pet.clean()
            imageView.setImageResource(R.drawable.imad10)
            updatePetStatusText(feedTextView, cleanTextView, playTextView)
        }

        btnExit.setOnClickListener {
            finish()

        }

        updatePetStatusText(feedTextView, cleanTextView, playTextView)
    }

    private fun updatePetStatusText(feedTextView: TextView, cleanTextView: TextView, playTextView: TextView) {
        feedTextView.text = "Hunger: ${pet.hunger}"
        cleanTextView.text = "Cleanliness: ${pet.cleanliness}"
        playTextView.text = "Health: ${pet.health}"
    }
}

class Pet {
    var health = 100
    var hunger = 10
    var cleanliness = 10

    fun feed() {
        hunger -= 10
        if (hunger < 0) hunger = 0
        health += 10
        if (health > 100) health = 100
    }

    fun clean() {
        cleanliness += 10
        if (cleanliness > 100) cleanliness = 100
        health += 10
        if (health > 100) health = 100
    }

    fun play() {
        health -= 15
        if (health < 0) health = 0
        hunger += 15
        if (hunger > 100) hunger = 100
        cleanliness -= 10
        if (cleanliness < 0) cleanliness = 0
    }
}
