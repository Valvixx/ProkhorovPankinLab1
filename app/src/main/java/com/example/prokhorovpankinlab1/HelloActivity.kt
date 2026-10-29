package com.example.prokhorovpankinlab1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HelloActivity : AppCompatActivity() {
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "HelloActivity onCreate")
        setContentView(R.layout.activity_helloact)

        loginEditText = findViewById(R.id.loginEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        savedInstanceState?.let {
            loginEditText.setText(it.getString(KEY_LOGIN))
            passwordEditText.setText(it.getString(KEY_PASSWORD))
        }

        findViewById<Button>(R.id.loginButton).setOnClickListener {
            if (loginEditText.text.isBlank() || passwordEditText.text.isBlank()) {
                Toast.makeText(this, R.string.fill_login_password, Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, MenuActivity::class.java))
            }
        }

        findViewById<Button>(R.id.registrationButton).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        findViewById<Button>(R.id.exitButton).setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "HelloActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "HelloActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "HelloActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "HelloActivity onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "HelloActivity onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "HelloActivity onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_LOGIN, loginEditText.text.toString())
        outState.putString(KEY_PASSWORD, passwordEditText.text.toString())
    }

    companion object {
        private const val TAG = "HelloActivity"
        private const val KEY_LOGIN = "login"
        private const val KEY_PASSWORD = "password"
    }
}
