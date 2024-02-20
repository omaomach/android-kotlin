package com.example.databindingobject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingobject.data.User
import com.example.databindingobject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var user1 : User = User(1, "Joel", "Asiago")

        binding.apply {
            userId.text = user1.id.toString()
            username.text = user1.name
            tvPassword.text = user1.password
        }

    }
}