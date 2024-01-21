package com.example.roommvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvm.data.User
import com.example.roommvvm.databinding.RowRvBinding
import com.example.roommvvm.generated.callback.OnClickListener

class UserAdapter(val users:List<User>,val clickListener: (User)->Unit):RecyclerView.Adapter<UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding:RowRvBinding=
            DataBindingUtil.inflate(layoutInflater,R.layout.row_rv,parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position],clickListener)
    }

    override fun getItemCount(): Int {
        return users.size
    }


}

class UserViewHolder(val binding: RowRvBinding):RecyclerView.ViewHolder(binding.root) {
fun bind(user: User,clickListener: (User)->Unit){
    binding.textViewNumber.text=user.id.toString()
    binding.textViewName.text=user.name
    binding.TextViewEmail.text=user.email
    binding.cardView.setOnClickListener(){
        clickListener(user)
    }
}
}
