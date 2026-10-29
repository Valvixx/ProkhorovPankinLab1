package com.example.prokhorovpankinlab1

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class UserListActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val userList = findViewById<ListView>(R.id.userList)
        val users = ArrayList<String>()
        val adapter = ArrayAdapter(this, R.layout.item, R.id.itemContent, users)
        userList.adapter = adapter

        findViewById<Button>(R.id.addButton).setOnClickListener {
            val name = "Пользователь ${users.size + 1}"
            users.add(name)
            adapter.notifyDataSetChanged()
            Log.i(TAG, "Нажата кнопка \"Добавить\": добавлен \"$name\", всего пользователей: ${users.size}")
        }
    }

    companion object {
        private const val TAG = "UserList"
    }
}
