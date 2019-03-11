package com.example.company.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val listMap = mutableMapOf<String, ArrayList<ProductItem>>(
            "первый список" to arrayListOf(ProductItem("ряженка", "кг", 1f)),
            "Ещё список" to arrayListOf(ProductItem("картошка")))

    val listNames = listMap.keys.toMutableList()

    var adapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNames)
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
            intent.putExtra("products", listMap[(view as TextView).text.toString()])
            startActivityForResult(intent, 3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data == null)
            return
        when (requestCode) {
            1 -> {
                val listName = data.getStringExtra("newList")
                listMap[listName] = arrayListOf()
                listNames.add(listName)
            }
            2 -> {
                val listName = data.getStringExtra("foundList")
                listMap[listName] = arrayListOf()
                listNames.add(listName)
            }
            3 -> {
                val listName = data.getStringExtra("editedList")
                listMap[listName] = data.getSerializableExtra("products") as ArrayList<ProductItem>
            }
        }
        adapter!!.notifyDataSetChanged()
    }
}