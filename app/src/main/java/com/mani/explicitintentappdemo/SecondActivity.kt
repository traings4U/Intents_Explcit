package com.mani.explicitintentappdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

public class SecondActivity : AppCompatActivity(), View.OnClickListener {

    var etUserName : EditText ?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val  tvBack = findViewById<TextView>(R.id.tvBack)

        etUserName = findViewById(R.id.etUserName)

        val userName = intent.extras!!.getString("userName")

        etUserName!!.setText(""+userName)
        tvBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val updatedText = etUserName!!.text.toString()

        intent = Intent()
        intent.putExtra("updatedText",updatedText)
        setResult(1002,intent)
        finish()
    }

}
