package com.example.contactsmanagerapp.viewUI

import androidx.recyclerview.widget.RecyclerView
import com.example.contactsmanagerapp.databinding.CardItemBinding
import com.example.contactsmanagerapp.room.User

class MyRecyclerViewAdapter(
    private val usersList: List<User>,
    private val clickListener: (User) -> Unit
    ) : RecyclerView.Adapter<MyViewHolder>() {



}

class MyViewHolder(val binding: CardItemBinding) :RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User, clickListener: (User) -> Unit) {
        binding.apply {
            nameTextView.text = user.name
            emailTextView.text = user.email
            listItemLayout.setOnClickListener() {
                clickListener(user)
            }
        }
    }

}