package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.entity.User
import com.example.quizapp.recycleview.UserDdapter
import com.example.testdb.database.AppDatabase
import kotlinx.android.synthetic.main.history.*

class history : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history)
        val userDao = AppDatabase.getDatabase(this).userDao()
//        val u1 = User("Tom",20)
//        val u2 = User("Sam",10)
        val userList2 = userDao.getAllUser()
        val adopter = UserDdapter(userList2)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adopter


//        flash.setOnClickListener {
//            thread {
//                userDao.insertUser(u1)
//                userDao.insertUser(u2)
//            }
//        }
    }
}
