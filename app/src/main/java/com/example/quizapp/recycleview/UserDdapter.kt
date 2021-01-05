package com.example.quizapp.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.entity.User

class UserDdapter(val userList:List<User>) :RecyclerView.Adapter<UserDdapter.ViewHolder>() {
    inner class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val username:TextView = view.findViewById(R.id.textView2)
        val score:TextView = view.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.username.text = user.username
        holder.score.text = user.score.toString()
    }

    override fun getItemCount(): Int {
       return userList.size
    }
}