package com.example.company.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.popup.*

class PopUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup)
        //setFinishOnTouchOutside(false)
        button_popup.setOnClickListener {
            val intent = Intent(this, NewListActivity::class.java)
            startActivity(intent)
        }
        var quantity = arrayOf("1 кг", "2 кг", "3 кг")
        var aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, quantity)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        with(spinner_product_quantity)
        {
            adapter = aa
            setSelection(0, false)
            //onItemSelectedListener = this@PopUpActivity
            prompt = "Выберите количество продукта"
            gravity = Gravity.CENTER

        }
    }

}