package com.example.prokhorovpankinlab1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<Button>(R.id.startButton).setOnClickListener {
            Log.i(TAG, "Start button pressed")
            Toast.makeText(this, R.string.start_pressed, Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.profileButton).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        findViewById<Button>(R.id.settingsButton).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        findViewById<Button>(R.id.problemButton).setOnClickListener {
            openProblemApp()
        }

        findViewById<Button>(R.id.menuExitButton).setOnClickListener {
            finish()
        }
    }

    private fun openProblemApp() {
        val gmailIntent = packageManager.getLaunchIntentForPackage("com.google.android.gm")
        if (gmailIntent != null) {
            startActivity(gmailIntent)
        } else {
            Log.e(TAG, "Gmail is not installed")
            Toast.makeText(this, R.string.no_problem_app, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val TAG = "MenuActivity"
    }
}
