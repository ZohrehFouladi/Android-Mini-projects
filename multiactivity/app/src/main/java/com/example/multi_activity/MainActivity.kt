package com.example.multi_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonEnter=findViewById<Button>(R.id.buttonEnter)
        buttonEnter.setOnClickListener{
             val parameterIntent= Intent(this, secondActiviy::class.java)
            startActivity(parameterIntent)
        }
    }
}