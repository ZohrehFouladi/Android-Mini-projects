@file:Suppress("DEPRECATION")

package com.example.apl

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apl.databinding.ActivityMainBinding
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonShowResult.setOnClickListener {
            getTemperature()
        }
    }

    fun getTemperature() {

        var cityName = binding.city.text
        val endPoint = "https://goweather.herokuapp.com/weather/$cityName"
        MyAsyncTask().execute(endPoint)
    }

    inner class MyAsyncTask : AsyncTask<String,String,String>() {
        override fun doInBackground(vararg params: String?): String {
            try {
                val url = URL(params[0])
                val urlConnect = url.openConnection() as HttpURLConnection
                urlConnect.connectTimeout = 10000
                val inString = convertStreamToString(urlConnect.inputStream)
                publishProgress(inString)
            } catch (ex: Exception) {
            }
            return ""
        }

        override fun onProgressUpdate(vararg values: String?) {
            try {
                val json = JSONObject(values[0])
                var temperature = json.getString("temperature")
                binding.textViewResult.text = temperature
            } catch (ex: Exception) {
            }
        }

        fun convertStreamToString(inputStream: InputStream): String {

            val bufferReader = BufferedReader(InputStreamReader(inputStream))
            var line: String
            var allString = ""
            try {
                do {
                    line = bufferReader.readLine()
                    allString += line
                } while (line != null)

            } catch (ex: Exception) {
            }
            return allString
        }
    }
}