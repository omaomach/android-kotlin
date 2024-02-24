package com.example.ldvmdbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ldvmdbapp.databinding.ActivityMainBinding
import com.example.ldvmdbapp.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding object
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)



        binding.apply {
            myViewModel = viewModel
            viewModel.counter.observe(this@MainActivity, Observer {
                textView.text = it.toString()
            })
        }

    }
}