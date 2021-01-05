package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.entity.User
import com.example.quizapp.recycleview.UserDdapter
import com.example.testdb.database.AppDatabase
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.history.*
import kotlin.concurrent.thread

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = userName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tv_score.text = "Your Score is $correctAnswers out of $totalQuestions."


        val userDao = AppDatabase.getDatabase(this).userDao()
        val u = User(userName,correctAnswers)
//        val userList2 = userDao.getAllUser()
//        val adopter = UserDdapter(userList2)
//        recyclerview.layoutManager = LinearLayoutManager(this)
//        recyclerview.adapter = adopter



        btn_finish.setOnClickListener {
            thread {
                userDao.insertUser(u)
            }
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
    }
}