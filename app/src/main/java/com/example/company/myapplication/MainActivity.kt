package com.example.company.myapplication

import android.app.ActionBar
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popup.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list1 = "Первый имеющийся список"
        val list2 = "Второй имеющийся список"
        val listItems = arrayOfNulls<String>(2)
        listItems[0] = list1
        listItems[1] = list2
        //val adapter = ArrayAdapter(this, android.R.layout.activity_list_item, textView.id , listItems)
        //lv_dynamic.adapter = adapter
        val tv = TextView(this)
        tv.text = listItems[0]
        tv.textSize = 20.toFloat()
        tv.layoutParams = ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT)
        ll.addView(tv)
        joinExisting.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent, savedInstanceState)
        }
        CreateNew.setOnClickListener {
            val intent = Intent(this, EnterListName::class.java)
            startActivity(intent, savedInstanceState)
        }
    }
}