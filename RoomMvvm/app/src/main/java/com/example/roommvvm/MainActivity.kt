package com.example.roommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roommvvm.data.User
import com.example.roommvvm.data.UserDatabase
import com.example.roommvvm.data.UserRepository
import com.example.roommvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = UserDatabase.getInstance(application).userDao
        val repository = UserRepository(dao)
        val factory = UserViewModelFactory(repository)

        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        binding.myViewModel = userViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
    }

    fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        loadUsers()
    }

    fun loadUsers() {
        userViewModel.users.observe(this, {
            binding.recyclerView.adapter = UserAdapter(it,{userItem:User->rowItemClicked(userItem)})
        })
    }
    fun rowItemClicked(user:User){
//        Toast.makeText(this,user.name,Toast.LENGTH_SHORT).show()
        userViewModel.updateOrDelete(user)
    }

}