package com.example.company.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.new_list.*
import kotlinx.android.synthetic.main.popup.*
import org.w3c.dom.Text

class NewListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_list)
        //var listTitle = ""
        var listTitle = intent.getStringExtra("listName").orEmpty()
        nameList.setText(listTitle.toString())
        addProduct.setOnClickListener {
            val intent = Intent(this, PopUpActivity::class.java)
            startActivity(intent)
        }
        addTimetable.setOnClickListener {
            val intent = Intent(this, TimelyAdd::class.java)
            startActivity(intent)
        }
    }
}

