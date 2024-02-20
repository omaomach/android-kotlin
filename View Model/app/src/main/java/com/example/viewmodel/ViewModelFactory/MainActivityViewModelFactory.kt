package com.example.viewmodel.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.ViewModel.MainActivityViewModel

class MainActivityViewModelFactory(private val startingNumber: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(startingNumber) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}