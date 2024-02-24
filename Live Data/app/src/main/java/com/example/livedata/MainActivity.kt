package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMainBinding
import com.example.livedata.viewmodel.MainActivityViewModel
import com.example.livedata.viewmodelfactory.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainActivityViewModel
    lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // view model factory
        viewModelFactory = MainActivityViewModelFactory(99)

        //connect view model to view model factory
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        // Observing for any data change
        viewModel.totalSum.observe(this, Observer {
            binding.tvCounter.text = it.toString()
        })

        binding.addBtn.setOnClickListener() {
            viewModel.sumUp(binding.editText.text.toString().toInt())
        }

    }
}