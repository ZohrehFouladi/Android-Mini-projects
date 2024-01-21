package com.example.multi_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class thirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val number= intent.getStringExtra("number")
    }
}