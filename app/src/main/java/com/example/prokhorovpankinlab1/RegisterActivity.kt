package com.example.prokhorovpankinlab1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "RegisterActivity onCreate")
        setContentView(R.layout.activity_register)

        nameEditText = findViewById(R.id.nameEditText)
        loginEditText = findViewById(R.id.registerLoginEditText)
        passwordEditText = findViewById(R.id.registerPasswordEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)

        savedInstanceState?.let {
            nameEditText.setText(it.getString(KEY_NAME))
            loginEditText.setText(it.getString(KEY_LOGIN))
            passwordEditText.setText(it.getString(KEY_PASSWORD))
            emailEditText.setText(it.getString(KEY_EMAIL))
            phoneEditText.setText(it.getString(KEY_PHONE))
        }

        findViewById<Button>(R.id.saveRegistrationButton).setOnClickListener {
            saveProfile()
            startActivity(Intent(this, MenuActivity::class.java))
        }

        findViewById<Button>(R.id.backToLoginButton).setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "RegisterActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "RegisterActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "RegisterActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "RegisterActivity onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "RegisterActivity onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "RegisterActivity onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NAME, nameEditText.text.toString())
        outState.putString(KEY_LOGIN, loginEditText.text.toString())
        outState.putString(KEY_PASSWORD, passwordEditText.text.toString())
        outState.putString(KEY_EMAIL, emailEditText.text.toString())
        outState.putString(KEY_PHONE, phoneEditText.text.toString())
    }

    private fun saveProfile() {
        getSharedPreferences(PROFILE_PREFS, MODE_PRIVATE)
            .edit()
            .putString(KEY_NAME, nameEditText.text.toString())
            .putString(KEY_LOGIN, loginEditText.text.toString())
            .putString(KEY_EMAIL, emailEditText.text.toString())
            .putString(KEY_PHONE, phoneEditText.text.toString())
            .apply()
    }

    companion object {
        const val PROFILE_PREFS = "profile"
        const val KEY_NAME = "name"
        const val KEY_LOGIN = "login"
        const val KEY_EMAIL = "email"
        const val KEY_PHONE = "phone"
        private const val TAG = "RegisterActivity"
        private const val KEY_PASSWORD = "password"
    }
}
