package com.example.bankomatsimulator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankomatsimulator.databinding.RecycleviewInstanceBinding

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    val users = mutableListOf<String>("One", "Two", "Three", "Four", "five", "Six", "Seven",
        "Eight", "Nine", "Ten")

    class UserViewHolder(
        val binding: RecycleviewInstanceBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecycleviewInstanceBinding.inflate(inflater)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return users.size
    }

}