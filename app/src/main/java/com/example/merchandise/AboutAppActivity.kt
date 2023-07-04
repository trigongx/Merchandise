package com.example.merchandise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.merchandise.databinding.ActivityAboutAppBinding

class AboutAppActivity : AppCompatActivity() {
    lateinit var binding: ActivityAboutAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAboutAppBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{
            finish()
        }

    }
}