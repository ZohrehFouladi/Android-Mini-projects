package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.recyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var persons=ArrayList<Person>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        persons.add(Person("maryam Sarvar","marym@gmail.com"))
        persons.add(Person("Mina Mirshahi","mina@gmail.com"))
        persons.add(Person("Zohreh Fouladi","zohreh@gmail.com"))
        persons.add(Person("Alireza Vahedi","alireza@gmail.com"))



//       val rv= findViewById<RecyclerView>(R.id.recyclerView)
//       rv.layoutManager= LinearLayoutManager(this)
//       rv.adapter=MyAdaptor(names,email)
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
        binding.recyclerView.adapter = MyAdaptor(persons)



    }
}