package com.example.quizapp.dao

import androidx.room.*
import com.example.quizapp.entity.User


@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User):Long

    @Query("select * from User")
    fun getAllUser():List<User>

    @Delete
    fun deleteById(user: User)

    @Update
    fun updateUser(newUser:User)
}