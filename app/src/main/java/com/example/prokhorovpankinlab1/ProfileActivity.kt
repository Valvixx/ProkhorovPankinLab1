package com.example.prokhorovpankinlab1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val prefs = getSharedPreferences(RegisterActivity.PROFILE_PREFS, MODE_PRIVATE)
        findViewById<TextView>(R.id.profileNameTextView).text =
            getString(R.string.profile_name_value, prefs.getString(RegisterActivity.KEY_NAME, ""))
        findViewById<TextView>(R.id.profileLoginTextView).text =
            getString(R.string.profile_login_value, prefs.getString(RegisterActivity.KEY_LOGIN, ""))
        findViewById<TextView>(R.id.profileEmailTextView).text =
            getString(R.string.profile_email_value, prefs.getString(RegisterActivity.KEY_EMAIL, ""))
        findViewById<TextView>(R.id.profilePhoneTextView).text =
            getString(R.string.profile_phone_value, prefs.getString(RegisterActivity.KEY_PHONE, ""))
    }
}
