package com.example.roommvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities =[User::class],version=1 )
abstract class UserDatabase : RoomDatabase(){
    abstract val userDao:UserDao
    companion object{
        private var INSTANCE: UserDatabase?= null


        fun getInstance(context:Context):UserDatabase{

           synchronized(this){
               var instance:UserDatabase?= INSTANCE
               if(instance==null){
                   instance=Room.databaseBuilder(context.applicationContext,UserDatabase::class.java,
                   "user_database").build()
               }
               return instance

            }
        }
    }
}