package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    var count=0
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCount.setOnClickListener{
            count++
            binding.textViewCount.text= count.toString()

        }
        binding.buttonDownload.setOnClickListener{
            CoroutineScope(Dispatchers.Default).launch {
                downloadData()
            }

        }
    }
    private suspend fun downloadData(){
        for(i in 1..500000){
//            Log.i("mylog",i.toString())
withContext(Dispatchers.Main){
    binding.textViewDownload.text=i.toString()
}
        }
    }
}