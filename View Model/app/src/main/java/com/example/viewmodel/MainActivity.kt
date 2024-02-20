package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.ViewModel.MainActivityViewModel
import com.example.viewmodel.ViewModelFactory.MainActivityViewModelFactory
import com.example.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var factory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // View Model Factory
        factory = MainActivityViewModelFactory(10)

        // View Model
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)

        binding.tvCounter.text = viewModel.getCurrentCount().toString()

        binding.apply {
            btn.setOnClickListener() {
                tvCounter.text = viewModel.getUpdatedCount().toString()
            }
        }

    }
}