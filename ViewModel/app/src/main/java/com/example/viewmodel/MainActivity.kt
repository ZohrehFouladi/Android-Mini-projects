package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        binding.TVnumber.text = myViewModel.getCount().toString()
        myViewModel.count.observe(this,{
            binding.TVnumber.text= it.toString()
        })
        myViewModel.state.observe(this,{
            if(it==true){
                binding.textView2.text="Even"
            }
            else{
                binding.textView2.text="odd"
            }
        })

        binding.BtnClick.setOnClickListener() {
            myViewModel.setCount(binding.editTextNumber.text.toString().toInt())
//            binding.TVnumber.text = myViewModel.getCount().toString()
myViewModel.state.value= (myViewModel.count.value.toString().toInt())%2==0
        }

    }
}