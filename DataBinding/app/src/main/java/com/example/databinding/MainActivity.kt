package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.u1=getUser()
        binding.buttonUpdate.setOnClickListener(){
            binding.u1= getUser2()
        }

    }

}
private fun getUser():User{

    val u=User("maryam", "ahmadi")
    return u
}
private fun getUser2():User{

    val u=User("mina", "mirshahi")
    return u
}



data class User( val name:String,val family:String){}
