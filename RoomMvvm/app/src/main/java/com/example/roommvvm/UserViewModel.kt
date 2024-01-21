package com.example.roommvvm

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roommvvm.data.User
import com.example.roommvvm.data.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(val repository: UserRepository) : ViewModel(), Observable {

    val users = repository.users
    var isUpdateOrDelete = false
    lateinit var userToUpdateOrDeelete: User

    @Bindable
    val inputName = MutableLiveData<String>()!!

    @Bindable
    val inputEmail = MutableLiveData<String>()!!

    @Bindable
    val updateSaveButtonText = MutableLiveData<String>()

    @Bindable
    val deleteDeleteAllButtonText = MutableLiveData<String>()


    init {
        updateSaveButtonText.value = "save"
        deleteDeleteAllButtonText.value = "delete All"
    }


    fun saveOrUpdate() {
        if (isUpdateOrDelete) {
            userToUpdateOrDeelete.name = inputName.value!!
            userToUpdateOrDeelete.email = inputEmail.value!!
            update(userToUpdateOrDeelete)
            resetFields()
        } else {
            val name: String = inputName.value!!
            val email: String = inputEmail.value!!
            insert(User(0, name, email))
            clean()
        }
    }

    fun update(user: User) {
        viewModelScope.launch {
            repository.update(userToUpdateOrDeelete)
        }
    }

    fun deleteOrDeleteAll() {
        if (isUpdateOrDelete) {
            delete(userToUpdateOrDeelete)
        } else {
            deleteAll()
            clean()
            viewModelScope.launch {
                repository.deleteAllAndResetId()
            }
        }
    }

    fun delete(user: User) {
        viewModelScope.launch {
            repository.delete(user)
            resetFields()
        }
    }

    private fun resetFields() {
        clean()
        isUpdateOrDelete = false
        updateSaveButtonText.value = "save"
        deleteDeleteAllButtonText.value = "delete All"
    }

    private fun clean() {
        inputName.value = null
        inputEmail.value = null
    }


    fun insert(user: User) {
        viewModelScope.launch {
            repository.insert(user)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    fun updateOrDelete(user: User) {
        inputName.value = user.name
        inputEmail.value = user.email
        updateSaveButtonText.value = "Update  "
        deleteDeleteAllButtonText.value = "Delete"
        isUpdateOrDelete = true
        userToUpdateOrDeelete = user
    }
}