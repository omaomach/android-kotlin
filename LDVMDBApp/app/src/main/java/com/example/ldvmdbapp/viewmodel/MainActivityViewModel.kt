package com.example.ldvmdbapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    // the counter variable has been made Read Only
    private var counter = MutableLiveData<Int>()
    val countData : LiveData<Int>
        get() = counter

    init {
        counter.value = 0
    }

    fun updateCounter() {
        counter.value = (counter.value)?.plus(1)
    }

}