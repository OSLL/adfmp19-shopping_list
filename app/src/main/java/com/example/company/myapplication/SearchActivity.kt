package com.example.company.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.new_list.*
import kotlinx.android.synthetic.main.no_such_list.*
import kotlinx.android.synthetic.main.search_list.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_list)
        var listName = ""
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                listName = editText.text.toString()
            }
        })

        searchButton.setOnClickListener {
            if (listName ==  "Существующий") {
                val intent = Intent(this, NewListActivity::class.java)
                //nameList.setText(listName) //TODO -- add to intent
                startActivity(intent)
            }
          else {
                val intent = Intent(this, NoSuchListActivity::class.java)
                startActivity(intent)
            }

        }

    }

}