package com.dekram.trumpetabc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dekram.trumpetabc.model.DependencyInjectorImpl
import com.dekram.trumpetabc.presenter.MainPresenter
import com.dekram.trumpetabc.views.FingeringsActivity
import com.dekram.trumpetabc.views.NotesCardActivity
import com.dekram.trumpetabc.views.TonesActivity

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var fingerings: TextView
    private lateinit var tones: TextView
    private lateinit var notesCards: TextView
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        setPresenter(MainPresenter(this, DependencyInjectorImpl()))
        presenter.onViewCreated()

        fingerings.setOnClickListener {
            displayFingerings()
        }

        tones.setOnClickListener {
            val intent = TonesActivity.newIntent(this)
            startActivity(intent)
        }

        notesCards.setOnClickListener {
            val intent = NotesCardActivity.newIntent(this)
            startActivity(intent)
        }
    }

    private fun initViews() {
        fingerings = findViewById(R.id.toFingerings)
        tones = findViewById(R.id.toTones)
        notesCards = findViewById(R.id.toNotesCards)
    }

    override fun displayMainActivity() {
        val context = applicationContext
        val intent = MainActivity.newIntent(context)
    }

    override fun displayFingerings() {
        val context = applicationContext
        val intent = FingeringsActivity.newIntent(context)
        startActivity(intent)
    }

    override fun displayTones() {
        TODO("Not yet implemented")
    }

    override fun displayNotesCards() {
        TODO("Not yet implemented")
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

}