package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.view.View
import android.text.method.ScrollingMovementMethod
import android.util.Log

private const val TAG = "main activity"
private const val TEXT_CONTENTS= "text contents"

class MainActivity : AppCompatActivity() {


private val textView:TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "+++++++++onCreate called  ")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var userInput = findViewById<EditText>(R.id.editText)
        var button = findViewById<Button>(R.id.button)
        var textView = findViewById<TextView>(R.id.textView)
//        textView.text = ""
        textView.movementMethod = ScrollingMovementMethod()

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "#########onclick called")
                textView.append(userInput.text)
                textView.append("\n")
//                numTimesClick += 1
//                textView?.append("button is tapped $numTimesClick time ")
//                if (numTimesClick != 1) {
//                    textView?.append("s\n")
//                } else {
//                    textView?.append("\n")
//                }
//                userInput.text.clear()
                userInput.setText("")
            }
        })


    }

    override fun onStart() {
        Log.d(TAG, "#########onStart called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "#########onRestore called")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text= savedInstanceState.getString(TEXT_CONTENTS,"")
    }

    override fun onResume() {
        Log.d(TAG, "#########onResume called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "#########onPause called")
        super.onPause()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "#########onSave called")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_CONTENTS,textView?.text.toString())
    }


    override fun onStop() {
        Log.d(TAG, "#########onStop called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "#########onRestore called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "#########onDestroy called")
        super.onDestroy()
    }


}
