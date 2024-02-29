package com.example.viewmodel.ViewModel

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private var counter = 10

    fun getCurrentCount(): Int {
        return counter
    }

    fun getUpdatedCount(): Int {
        return ++counter
    }

}