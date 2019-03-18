package com.example.company.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val dataHolder = DataHolder()

    var adapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataHolder.getListsNames())
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
            intent.putExtra("products", dataHolder.getListByName((view as TextView).text.toString()))
            startActivityForResult(intent, 3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data == null)
            return
        when (requestCode) {
            1 -> {
                val listName = data.getStringExtra("newList")
                dataHolder.insertEmptyList(listName)
            }
            2 -> {
                val listName = data.getStringExtra("foundList")
                dataHolder.insertEmptyList(listName)
            }
            3 -> {
                val listName = data.getStringExtra("editedList")
                dataHolder.replaceExistingList(
                        listName,
                        data.getSerializableExtra("products") as ArrayList<ProductItem>)
            }
        }
        adapter!!.notifyDataSetChanged()
    }
}