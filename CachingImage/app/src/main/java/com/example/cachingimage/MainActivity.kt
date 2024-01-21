package com.example.cachingimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.bumptech.glide.Glide
import com.example.cachingimage.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

open class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.buttonDownLoad.setOnClickListener(){
            loadImage()
        }
    }
    fun loadImage(){
        val url="https://picsum.photos/300"
        Glide.with(this)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imageView)

    }


}