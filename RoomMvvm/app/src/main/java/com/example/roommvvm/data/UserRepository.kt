package com.example.roommvvm.data

class UserRepository(val dao:UserDao) {
    val users= dao.getAllUsers()


    suspend fun insert(user:User){
        dao.insertUser(user)
    }
    suspend fun update(user:User){
        dao.updateUser(user)
    }
    suspend fun delete(user: User){
        dao.deleteUser(user)
    }
    suspend fun deleteAll(){
        dao.deleteAll()
    }
    suspend fun deleteAllAndResetId() {
        dao.deleteAllAndResetId()
    }

}