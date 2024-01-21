package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.PersonlayoutBinding


class MyAdaptor(var persons:ArrayList<Person> ) :
    RecyclerView.Adapter<MyAdaptor.ViewHolder>() {

    inner class ViewHolder(private val binding:PersonlayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String, email: String) {
            binding.textView.text = name
            binding.textView2.text = email
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

//        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.personlayout, parent, false)
//        return ViewHolder(v)
        val inflater = LayoutInflater.from(parent.context)
        val binding = PersonlayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(persons[position].name, persons[position].email)
//        holder.bind(name[position], email[position])
    }


    override fun getItemCount(): Int {
        return persons.size
    }


}