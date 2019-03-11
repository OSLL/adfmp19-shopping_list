package com.example.company.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.popup.*
import javax.xml.transform.OutputKeys

class PopUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup)
        //setFinishOnTouchOutside(false)

        var quantity = arrayOf("0.5", "1.0", "1.5", "2")
        var units = arrayOf("кг", "шт")
        var aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, quantity)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        var aa1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(spinner_product_quantity)
        {
            adapter = aa
            setSelection(0, false)
            prompt = "Выберите количество продукта"
            gravity = Gravity.CENTER

        }

        with(spinner_product_unit)
        {
            adapter = aa1
            setSelection(0, false)
            prompt = "Единица измерения"
            gravity = Gravity.CENTER

        }

        button_popup.setOnClickListener {
            val intent = Intent()
            intent.putExtra("newProduct", text_view_popup.text.toString())
            intent.putExtra("quantity" ,spinner_product_quantity.selectedItem.toString().toFloat())
            intent.putExtra("productUnit", spinner_product_unit.selectedItem.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}