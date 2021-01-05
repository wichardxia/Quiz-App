package com.example.quizapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var username:String, var score: Int){
    @PrimaryKey(autoGenerate = true)
    var id: Long=0
}