package com.example.company.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val listMap = mutableMapOf<String, ArrayList<String>>(
            "первый список" to arrayListOf<String>("ряженка"),
            "Ещё список" to arrayListOf("Груши", "Картошка"))
    var adapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listMap.keys.toList())
        lv.adapter = this!!.adapter

        joinExisting.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivityForResult(intent, 2)
        }

        CreateNew.setOnClickListener {
            val intent = Intent(this, EnterListName::class.java)
            startActivityForResult(intent, 1)
        }

        lv.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ChangeListActivity::class.java)
            intent.putExtra("listName", (view as TextView).text.toString())
            intent.putStringArrayListExtra("products", listMap[(view as TextView).text.toString()])
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data == null)
            return
        when (requestCode) {
            1 -> listMap[data.getStringExtra("newList")] = arrayListOf()
            2 -> listMap.put(data.getStringExtra("foundList"), arrayListOf())
        }
        adapter!!.notifyDataSetChanged()
    }
}