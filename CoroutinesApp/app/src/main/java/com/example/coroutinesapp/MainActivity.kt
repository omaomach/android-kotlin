package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutinesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private var counter : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            countBtn.setOnClickListener {
                counterTextView.text = counter++.toString()
            }

            downloadBtn.setOnClickListener {
                downloadBigFileFromNet()
            }

        }



    }

    private fun downloadBigFileFromNet() {
        for (i in 1..100000) {
            Log.i("Tag", "Downloading $i in ${Thread.currentThread().name}")
        }
    }
}