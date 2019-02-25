package com.example.company.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_delete_or_unselect.*

class delete_or_unselect : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_or_unselect)

        textView.text = "Что вы хотите сделать с "
                .plus(intent.getStringExtra("product"))
                .plus(" ?")

        delete.setOnClickListener {
            val intent = Intent()
            intent.putExtra("tappedVal", this.intent.getIntExtra("tappedVal", 0))
            intent.putExtra("deleteOption", "delete")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        unselect.setOnClickListener {
            val intent = Intent()
            intent.putExtra("tappedVal", this.intent.getIntExtra("tappedVal", 0))
            intent.putExtra("deleteOption", "unselect")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        cancel.setOnClickListener {
            finish()
        }
    }
}
