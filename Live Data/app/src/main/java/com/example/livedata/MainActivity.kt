package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMainBinding
import com.example.livedata.viewmodel.MainActivityViewModel
import com.example.livedata.viewmodelfactory.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // view model factory
        viewModelFactory = MainActivityViewModelFactory(100)

        //connect view model to view model factory
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        // Observing for any data change
        viewModel.totalSum.observe(this, Observer {
            binding.tvCounter.text = it.toString()
        })

//        binding.addBtn.setOnClickListener() {
//            viewModel.sumUp(binding.editText.text.toString().toInt())
//        }

        binding.apply {
            addBtn.setOnClickListener() {
                if (editText.text?.isNotEmpty() == true) {
                    viewModel.sumUp(editText.text.toString().toInt())
                }else {
                    Toast.makeText(this@MainActivity,
                        "Please Enter Number", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}