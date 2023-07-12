package com.dekram.trumpetabc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO

class ScalesActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var scalesViewImage: ImageView
    private lateinit var minorSpinner: Spinner
    private lateinit var majorSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scales)
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)

        scalesViewImage = findViewById(R.id.scales)
        minorSpinner = findViewById(R.id.minor_spinner)
        majorSpinner = findViewById(R.id.major_spinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.minor_scales,
            android.R.layout.simple_spinner_item
        ).also { minorAdapter ->
            minorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            minorSpinner.adapter = minorAdapter
        }

        minorSpinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            this,
            R.array.major_scales,
            android.R.layout.simple_spinner_item
        ).also { majorAdapter ->
            majorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            majorSpinner.adapter = majorAdapter
        }

        majorSpinner.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        if (parent?.id == R.id.minor_spinner) {
            val minorArray = resources.getStringArray(R.array.minor_scales)
            when(minorArray[position]) {
                "a-moll" -> scalesViewImage.setImageResource(R.drawable.scales_a_moll)
                "e-moll" -> scalesViewImage.setImageResource(R.drawable.scales_e_moll)
                "h-moll" -> scalesViewImage.setImageResource(R.drawable.scales_h_moll)
                "fis-moll" -> scalesViewImage.setImageResource(R.drawable.scales_fis_moll)
                "cis-moll" -> scalesViewImage.setImageResource(R.drawable.scales_cis_moll)
                "gis-moll" -> scalesViewImage.setImageResource(R.drawable.scales_gis_moll)
                "dis-moll" -> scalesViewImage.setImageResource(R.drawable.scales_dis_moll)
                "ais-moll" -> scalesViewImage.setImageResource(R.drawable.scales_ais_moll)
                "d-moll" -> scalesViewImage.setImageResource(R.drawable.scales_d_moll)
                "g-moll" -> scalesViewImage.setImageResource(R.drawable.scales_g_moll)
                "c-moll" -> scalesViewImage.setImageResource(R.drawable.scales_c_moll)
                "f-moll" -> scalesViewImage.setImageResource(R.drawable.scales_f_moll)
                "b-moll" -> scalesViewImage.setImageResource(R.drawable.scales_b_moll)
                "es-moll" -> scalesViewImage.setImageResource(R.drawable.scales_es_moll)
                "as-moll" -> scalesViewImage.setImageResource(R.drawable.scales_as_moll)
            }
        }

        if (parent?.id == R.id.major_spinner) {
            val majorArray = resources.getStringArray(R.array.major_scales)
            when(majorArray[position]) {
                "C-dur" -> scalesViewImage.setImageResource(R.drawable.scales_c_dur)
                "G-dur" -> scalesViewImage.setImageResource(R.drawable.scales_g_dur)
                "D-dur" -> scalesViewImage.setImageResource(R.drawable.scales_d_dur)
                "A-dur" -> scalesViewImage.setImageResource(R.drawable.scales_a_dur)
                "E-dur" -> scalesViewImage.setImageResource(R.drawable.scales_e_dur)
                "H-dur" -> scalesViewImage.setImageResource(R.drawable.scales_h_dur)
                "Fis-dur" -> scalesViewImage.setImageResource(R.drawable.scales_fis_dur)
                "Cis-dur" -> scalesViewImage.setImageResource(R.drawable.scales_cis_dur)
                "F-dur" -> scalesViewImage.setImageResource(R.drawable.scales_f_dur)
                "B-dur" -> scalesViewImage.setImageResource(R.drawable.scales_b_dur)
                "Es-dur" -> scalesViewImage.setImageResource(R.drawable.scales_es_dur)
                "As-dur" -> scalesViewImage.setImageResource(R.drawable.scales_as_dur)
                "Des-dur" -> scalesViewImage.setImageResource(R.drawable.scales_des_dur)
                "Ges-dur" -> scalesViewImage.setImageResource(R.drawable.scales_ges_dur)
                "Ces-dur" -> scalesViewImage.setImageResource(R.drawable.scales_ces_dur)
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        return
    }


}