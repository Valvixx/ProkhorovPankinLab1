package com.example.prokhorovpankinlab1

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup

class RegistrationFormActivity : Activity() {

    private val avatars = intArrayOf(
        android.R.drawable.ic_menu_gallery,
        android.R.drawable.ic_menu_camera,
        android.R.drawable.ic_menu_myplaces
    )
    private var avatarIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_form)

        val avatarImageView = findViewById<ImageView>(R.id.avatarImageView)
        val loginEditText = findViewById<EditText>(R.id.loginEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val fioEditText = findViewById<EditText>(R.id.fioEditText)
        val birthDateEditText = findViewById<EditText>(R.id.birthDateEditText)
        val genderRadioGroup = findViewById<RadioGroup>(R.id.genderRadioGroup)

        // Выбор аватара: по кнопке или по клику на саму картинку
        val chooseAvatar = {
            avatarIndex = (avatarIndex + 1) % avatars.size
            avatarImageView.setImageResource(avatars[avatarIndex])
            Log.i(TAG, "Выбран аватар номер $avatarIndex")
        }
        findViewById<Button>(R.id.chooseAvatarButton).setOnClickListener { chooseAvatar() }
        avatarImageView.setOnClickListener { chooseAvatar() }

        findViewById<Button>(R.id.registerButton).setOnClickListener {
            val gender = if (genderRadioGroup.checkedRadioButtonId == R.id.maleRadioButton) "М" else "Ж"
            Log.i(
                TAG,
                "Нажата кнопка регистрации: логин=${loginEditText.text}, " +
                    "пароль=${passwordEditText.text}, ФИО=${fioEditText.text}, " +
                    "дата рождения=${birthDateEditText.text}, пол=$gender, аватар=$avatarIndex"
            )
        }
    }

    companion object {
        private const val TAG = "RegistrationForm"
    }
}
