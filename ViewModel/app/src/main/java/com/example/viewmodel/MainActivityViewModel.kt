package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var count = MutableLiveData<Int>()
    var state = MutableLiveData<Boolean>()

    init {
        count.value = 0
      state.value=true
    }


    //    fun getCount():Int{
//        return count
//    }
    fun setCount(value: Int) {
        if (value > 0) {
            count.value = (count.value)?.plus(value)
        }

    }


}