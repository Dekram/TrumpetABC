package com.dekram.trumpetabc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var fingerings: TextView
    private lateinit var tones: TextView
    private lateinit var notesCards: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fingerings = findViewById(R.id.toFingerings)
        tones = findViewById(R.id.toTones)
        notesCards = findViewById(R.id.toNotesCards)

        fingerings.setOnClickListener {
            val intent = Intent(this, FingeringsActivity::class.java)
            startActivity(intent)
        }

        tones.setOnClickListener {
            val intent = Intent(this, TonesActivity::class.java)
            startActivity(intent)
        }

        notesCards.setOnClickListener {
            val intent = Intent(this, NotesCardActivity::class.java)
            startActivity(intent)
        }
    }
}