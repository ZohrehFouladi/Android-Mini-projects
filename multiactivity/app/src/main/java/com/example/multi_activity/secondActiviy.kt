package com.example.multi_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class secondActiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_activiy)
        val buttonSubmit= findViewById<Button>(R.id.buttonSubmit)
        val editTextNumber= findViewById<EditText>(R.id.editTextNumber)

        buttonSubmit.setOnClickListener{
            val parameterInfo= Intent( this, thirdActivity::class.java)
            parameterInfo.putExtra( "number", editTextNumber.text)
            startActivity(parameterInfo)
        }
    }
}