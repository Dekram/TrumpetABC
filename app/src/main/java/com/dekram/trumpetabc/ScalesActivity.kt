package com.dekram.trumpetabc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class ScalesActivity : AppCompatActivity() {

    private lateinit var minorSpinner: Spinner
    private lateinit var majorSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scales)

        minorSpinner = findViewById(R.id.minor_spinner)
        majorSpinner = findViewById(R.id.major_spinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.minor_scales,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            minorSpinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.major_scales,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            majorSpinner.adapter = adapter
        }
    }
}