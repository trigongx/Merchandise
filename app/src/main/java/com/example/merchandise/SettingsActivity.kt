package com.example.merchandise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.merchandise.databinding.ActivityMainBinding
import com.example.merchandise.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}