package com.example.merchandise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.merchandise.databinding.ActivityEditBinding
import com.example.merchandise.databinding.ActivitySupportBinding

class SupportActivity : AppCompatActivity() {
    lateinit var binding: ActivitySupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{
            finish()
        }

    }
}