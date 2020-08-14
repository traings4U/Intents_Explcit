package com.mani.explicitintentappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var  etUserName : EditText?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUserName = findViewById(R.id.etUserName)
        val tvNext = findViewById<TextView>(R.id.tvNext)

        tvNext.setOnClickListener(this)
    }

    override fun onClick(v: View?) {


        val userName = etUserName!!.text.toString()
        intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("userName",userName)
        //startActivity(intent)
        startActivityForResult(intent,1001)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode ==1001 && resultCode ==1002)
        {
            val updatedText = data!!.extras!!.getString("updatedText")

            etUserName!!.setText(""+updatedText)
        }
    }
}