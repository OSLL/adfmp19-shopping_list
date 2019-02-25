package com.example.company.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.new_list.*

class ChangeListActivity : AppCompatActivity() {

    //val productsList = mutableListOf("Продукт 1", "Продукт 2")
    var productsList : ArrayList<String>? = null

    var listTitle : String? = null

    var adapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_list)

        listTitle = intent.getStringExtra("listName").orEmpty()

        nameList.text = listTitle

        productsList = intent.getStringArrayListExtra("products")

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productsList as MutableList<String>)

        lv.adapter = adapter

        lv.setOnItemClickListener { parent, view, position, id ->
            (view as TextView).setBackgroundColor(Color.CYAN)
        }

        lv.setOnItemLongClickListener { parent, view, position, id ->
            val intent = Intent(this, delete_or_unselect::class.java)
            intent.putExtra("tappedVal", position)
            intent.putExtra("product", (view as TextView).text.toString())
            startActivityForResult(intent, 3)
            true
        }

        addProduct.setOnClickListener {
            val intent = Intent(this, PopUpActivity::class.java)
            startActivityForResult(intent, 1)
        }

        addTimetable.setOnClickListener {
            val intent = Intent(this, TimelyAdd::class.java)
            startActivityForResult(intent, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null)
            return
        when (requestCode) {
            1 -> {
                productsList!!.add(data.getStringExtra("newProduct"))
                adapter!!.notifyDataSetChanged()
            }
            3 -> {
                val pos = data.getIntExtra("tappedVal", 0)
                when (data.getStringExtra("deleteOption")) {
                    "delete" -> {
                        productsList!!.removeAt(pos)
                    }
                    "unselect" -> {
                        lv.getChildAt(pos).setBackgroundColor(Color.GRAY)
                    }
                }
                adapter!!.notifyDataSetChanged()
            }
        }
    }

}

