package com.dekram.trumpetabc.views

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.dekram.trumpetabc.MainActivity
import com.dekram.trumpetabc.R

class SplashActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeFullScreen()

        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            // start activity
            startActivity(Intent(this, MainActivity::class.java))
            // animate splash screen
            overrideActivityTransition(OVERRIDE_TRANSITION_OPEN, android.R.anim.fade_in, android.R.anim.fade_out)
            // close splash screen
            finish()
        }, 2000)
    }

    private fun makeFullScreen() {
        // Remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        // Make fullscreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        // Hide toolbar
        supportActionBar?.hide()
    }

//    private fun startMainActivity() {
//        val intent = MainActivity.newInstance(this)
//        startActivity(intent)
//    }
}