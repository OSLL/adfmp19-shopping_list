package com.example.company.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.enter_list_name.*

class EnterListName: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.enter_list_name)
        CreateNewList.setOnClickListener {
            val intent = Intent(this, NewListActivity ::class.java)
            var name = enterListName.text.toString()
            intent.putExtra("listName", name)
            startActivity(intent)
        }
    }
}