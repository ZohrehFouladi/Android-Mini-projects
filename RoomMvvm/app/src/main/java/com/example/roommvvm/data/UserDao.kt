package com.example.roommvvm.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao

interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table ")
    suspend fun deleteAll()

    @Query("DELETE FROM sqlite_sequence WHERE name = 'user_table'")
    suspend fun resetId()

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): LiveData<List<User>>

    suspend fun deleteAllAndResetId() {
        deleteAll()
        resetId()
    }
}