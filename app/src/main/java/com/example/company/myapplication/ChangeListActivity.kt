package com.example.company.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.new_list.*

class ChangeListActivity : AppCompatActivity() {

    //val productsList = mutableListOf("Продукт 1", "Продукт 2")
    var productsList : ArrayList<ProductItem>? = null

    var listTitle : String? = null

    var adapter : ArrayAdapter<ProductItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_list)

        listTitle = intent.getStringExtra("listName").orEmpty()

        nameList.text = listTitle

        productsList = intent.getSerializableExtra("products") as ArrayList<ProductItem>?

        adapter = ArrayAdapter<ProductItem>(this, android.R.layout.simple_list_item_1, productsList)

        lv.adapter = adapter

        lv.setOnItemClickListener { parent, view, position, id ->
            productsList!![position].isSelected = true;
            adapter!!.notifyDataSetChanged()
        }

        lv.setOnItemLongClickListener { parent, view, position, id ->
            val intent = Intent(this, DeleteOrUnselectActivity::class.java)
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

        val intent = Intent()
        intent.putExtra("editedList", listTitle)
        intent.putExtra("products", productsList)
        setResult(Activity.RESULT_OK, intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null)
            return
        when (requestCode) {
            1 -> {
                productsList!!.add(
                        ProductItem(
                                data.getStringExtra("newProduct"),
                                data.getStringExtra("productUnit"),
                                data.getFloatExtra("quantity", 0f)))
                adapter!!.notifyDataSetChanged()
            }
            3 -> {
                val pos = data.getIntExtra("tappedVal", 0)
                when (data.getStringExtra("deleteOption")) {
                    "delete" -> {
                        productsList!!.removeAt(pos)
                    }
                    "unselect" -> {
                        productsList!![pos].isSelected = false
                    }
                }
                adapter!!.notifyDataSetChanged()
            }
        }
    }
}

